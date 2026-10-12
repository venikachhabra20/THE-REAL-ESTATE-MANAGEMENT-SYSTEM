

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found", e);
        }

        String url = "jdbc:mysql://localhost:3306/real_estate_systemdb";
        String username = "root";
        String password = "2525";

        return DriverManager.getConnection(url, username, password);
    }
}