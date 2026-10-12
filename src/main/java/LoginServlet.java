import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String context = request.getContextPath();

        if (email == null || password == null
                || email.isBlank() || password.isBlank()) {
            response.sendRedirect(context + "/login.html?error=empty");
            return;
        }

        email = email.trim();

        String sql = """
            SELECT user_id, name, email, password, role
            FROM users
            WHERE email = ?
            """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet result = statement.executeQuery()) {

                if (!result.next()) {
                    response.sendRedirect(
                            context + "/login.html?error=invalid");
                    return;
                }

                int userId = result.getInt("user_id");
                String name = result.getString("name");
                String dbEmail = result.getString("email");
                String storedPassword = result.getString("password");
                String role = result.getString("role");

                boolean passwordMatches = false;

                // BCrypt hashes start with "$2".
                if (storedPassword != null
                        && storedPassword.startsWith("$2")) {

                    passwordMatches =
                            BCrypt.checkpw(password, storedPassword);

                } else if (storedPassword != null
                        && password.equals(storedPassword)) {

                    // Upgrade an existing plain-text password
                    // after a successful login.
                    String hashedPassword =
                            BCrypt.hashpw(password, BCrypt.gensalt(12));

                    String updateSql =
                            "UPDATE users SET password = ? WHERE user_id = ?";

                    try (PreparedStatement update =
                            connection.prepareStatement(updateSql)) {

                        update.setString(1, hashedPassword);
                        update.setInt(2, userId);
                        update.executeUpdate();
                    }

                    passwordMatches = true;
                }

                if (!passwordMatches) {
                    response.sendRedirect(
                            context + "/login.html?error=invalid");
                    return;
                }

                if (!"USER".equalsIgnoreCase(role)
                        && !"ADMIN".equalsIgnoreCase(role)) {
                    response.sendRedirect(
                            context + "/login.html?error=invalid");
                    return;
                }

                // Start a fresh session after successful login.
                HttpSession oldSession = request.getSession(false);

                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession session = request.getSession(true);
                session.setAttribute("userId", userId);
                session.setAttribute("userName", name);
                session.setAttribute("userEmail", dbEmail);
                session.setAttribute("role", role.toUpperCase());
                session.setMaxInactiveInterval(30 * 60);

                if ("ADMIN".equalsIgnoreCase(role)) {
                    response.sendRedirect(
                            context + "/admin/dashboard.html");
                } else {
                    response.sendRedirect(
                            context + "/user/dashboard.html");
                }
            }

        } catch (Exception e) {
            getServletContext().log("Login processing failed", e);

            response.sendRedirect(
                    context + "/login.html?error=server");
        }
    }
}