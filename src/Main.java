import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate the catering service
public class Main {
    public static void main(String[] args) {
        CateringService cateringService = new CateringService();
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Customer 1: Add items to the menu and display it
        cateringService.addItemToMenu("Pasta Carbonara");
        cateringService.displayMenu();

        // Customer 2: Place an order and leave a review
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Chicken Alfredo");
        orderItems.add("Beef Tacos");
        customer2.placeOrder(cateringService, orderItems);
        customer2.leaveReview(5);

    }
}