public class Room {
    private String type;
    private double price;
    private boolean isAvailable;

    public Room(String type, double price, boolean isAvailable) {
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    public void release() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room Type: " + type + " | Price: " + price + " | Available: " + (isAvailable ? "Yes" : "No");
    }
}
