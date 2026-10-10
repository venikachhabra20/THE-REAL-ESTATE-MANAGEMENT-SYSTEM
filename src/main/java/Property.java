
public class Property {

    private int propertyId;
    private String title;
    private String location;
    private double price;
    private String status;

    public Property(int propertyId, String title, String location,
                    double price, String status) {
        this.propertyId = propertyId;
        this.title = title;
        this.location = location;
        this.price = price;
        this.status = status;
    }

    public void displayDetails() {
        System.out.println("Property ID: " + propertyId);
        System.out.println("Title: " + title);
        System.out.println("Location: " + location);
        System.out.println("Price: Rs. " + price);
        System.out.println("Status: " + status);
    }
}