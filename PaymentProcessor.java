import java.util.Scanner;

public class PaymentProcessor {
    public static boolean processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total Price: " + amount);
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();
        
        if (payment >= amount) {
            System.out.println("Payment successful! Thank you for your reservation.");
            return true;
        } else {
            System.out.println("Payment failed. Please check the amount and try again.");
            return false;
        }
    }
}
