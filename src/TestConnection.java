
public class TestConnection {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}