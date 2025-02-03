import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private static List<Room> rooms = new ArrayList<>();
    private static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize rooms
        rooms.add(new Room("Single", 100.00, true));
        rooms.add(new Room("Double", 150.00, true));
        rooms.add(new Room("Suite", 250.00, true));
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Hotel Reservation System!");
        
        while (true) {
            System.out.println("\n1. Search for Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void searchRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();
        
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isAvailable()) {
                System.out.println(i + 1 + ". " + rooms.get(i));
            }
        }
        
        System.out.print("\nChoose a room to reserve: ");
        int roomChoice = scanner.nextInt() - 1;

        if (roomChoice >= 0 && roomChoice < rooms.size() && rooms.get(roomChoice).isAvailable()) {
            Room selectedRoom = rooms.get(roomChoice);
            selectedRoom.reserve();
            Reservation reservation = new Reservation(selectedRoom, guestName, checkInDate, checkOutDate);
            reservations.add(reservation);

            System.out.println("\nReservation Successful!");
            PaymentProcessor.processPayment(selectedRoom.getPrice());
        } else {
            System.out.println("Invalid room choice or room not available.");
        }
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
