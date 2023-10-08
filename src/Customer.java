import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    // Method 9: Place an order with a list of items
    public void placeOrder(CateringService cateringService, List<String> orderItems) {
        System.out.println(name + " is placing an order.");
        cateringService.processOrder(orderItems);
    }

    // Method 10: Leave a review with an if-else condition
    public void leaveReview(int rating) {
        if (rating >= 4) {
            System.out.println("Thank you for your positive review!");
        } else {
            System.out.println("We're sorry to hear that. Please let us know how we can improve.");
        }
    }
}
