
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/properties")
public class PropertiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("application/json;charset=UTF-8");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "SELECT property_id, title, description, location, " +
                     "price, property_type, status, bedrooms, bathrooms, area_sqft " +
                     "FROM properties");
             ResultSet rs = ps.executeQuery();
             PrintWriter out = response.getWriter()) {

            out.print("[");
            boolean first = true;

            while (rs.next()) {
                if (!first) {
                    out.print(",");
                }

                out.print("{");
                out.print("\"property_id\":" + rs.getInt("property_id") + ",");
                out.print("\"title\":\"" + escape(rs.getString("title")) + "\",");
                out.print("\"description\":\"" + escape(rs.getString("description")) + "\",");
                out.print("\"location\":\"" + escape(rs.getString("location")) + "\",");
                out.print("\"price\":" + rs.getBigDecimal("price") + ",");
                out.print("\"property_type\":\"" + escape(rs.getString("property_type")) + "\",");
                out.print("\"status\":\"" + escape(rs.getString("status")) + "\",");
                out.print("\"bedrooms\":" + rs.getInt("bedrooms") + ",");
                out.print("\"bathrooms\":" + rs.getInt("bathrooms") + ",");
                out.print("\"area_sqft\":" + rs.getInt("area_sqft"));
                out.print("}");

                first = false;
            }

            out.print("]");

        } catch (Exception e) {
            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json;charset=UTF-8");

            try {
                response.getWriter().print(
                        "{\"error\":\"Unable to load properties from database\"}");
            } catch (IOException ignored) {
                // Response could not be written.
            }

            e.printStackTrace();
        }
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }
}
