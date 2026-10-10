
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
        String username = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        if (username == null || password == null) {
            throw new SQLException(
                "Please configure DB_USERNAME and DB_PASSWORD environment variables."
            );
        }

        return DriverManager.getConnection(url, username, password);
    }
}
