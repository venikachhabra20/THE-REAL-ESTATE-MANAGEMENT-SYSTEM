
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test-db")
public class PropertyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            try (Connection connection =
                     DBConnection.getConnection()) {

                out.println("<html><body>");
                out.println("<h1>Real Estate Management System</h1>");
                out.println("<h2>Java Backend is Working!</h2>");
                out.println("<p>MySQL database connected successfully.</p>");
                out.println("</body></html>");

            } catch (Exception e) {
    e.printStackTrace();
    out.println("<h2>Database connection failed.</h2>");
    out.println("<p>Error: " + e.getMessage() + "</p>");
            }
        }
    }
}