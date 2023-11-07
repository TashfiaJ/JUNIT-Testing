import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John Doe");
    }

    @Test
    public void testPlaceOrder() {
        // Redirect standard output to capture the printed order details
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CateringService cateringService = new CateringService();
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Chicken Alfredo");

        customer.placeOrder(cateringService, orderItems);

        String orderOutput = outputStream.toString();
        assertTrue(orderOutput.contains("John Doe is placing an order."));
        assertTrue(orderOutput.contains("Total Cost (Before Discount): $10.0"));
        assertTrue(orderOutput.contains("Final Cost (After Discount): $10.0"));

        // Reset the standard output
        System.setOut(System.out);
    }

    @Test
    public void testLeavePositiveReview() {
        // Redirect standard output to capture the printed review message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int rating = 5;
        customer.leaveReview(rating);

        String reviewOutput = outputStream.toString();
        assertTrue(reviewOutput.contains("Thank you for your positive review!"));

        // Reset the standard output
        System.setOut(System.out);
    }

    @Test
    public void testLeaveNegativeReview() {
        // Redirect standard output to capture the printed review message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int rating = 2;
        customer.leaveReview(rating);

        String reviewOutput = outputStream.toString();
        assertTrue(reviewOutput.contains("We're sorry to hear that. Please let us know how we can improve."));

        // Reset the standard output
        System.setOut(System.out);
    }
}
