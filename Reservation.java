public class Reservation {
    private Room room;
    private String guestName;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(Room room, String guestName, String checkInDate, String checkOutDate) {
        this.room = room;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return "Reservation for: " + guestName + "\nRoom: " + room.getType() + "\nCheck-in: " + checkInDate + "\nCheck-out: " + checkOutDate;
    }
}
