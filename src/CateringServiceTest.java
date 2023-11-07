import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CateringServiceTest {

    private CateringService cateringService;

    @Before
    public void setUp() {
        cateringService = new CateringService();
    }

    @Test
    public void testAddItemToMenu() {
        String itemToAdd = "Sushi";
        cateringService.addItemToMenu(itemToAdd);
        assertTrue(cateringService.isItemAvailable(itemToAdd));
    }

    @Test
    public void testAddNullItemToMenu() {
        String itemToAdd = null;
        cateringService.addItemToMenu(itemToAdd);
        assertFalse(cateringService.isItemAvailable(itemToAdd));
    }

    @Test
    public void testAddEmptyItemToMenu() {
        String itemToAdd = "";
        cateringService.addItemToMenu(itemToAdd);
        assertFalse(cateringService.isItemAvailable(itemToAdd));
    }

    @Test
    public void testRemoveItemFromMenu() {
        String itemToRemove = "Beef Tacos";
        cateringService.removeItemFromMenu(itemToRemove);
        assertFalse(cateringService.isItemAvailable(itemToRemove));
    }

    @Test
    public void testRemoveNonExistingItemFromMenu() {
        String itemToRemove = "Pasta";
        cateringService.removeItemFromMenu(itemToRemove);
        assertFalse(cateringService.isItemAvailable(itemToRemove));
    }

    @Test
    public void testDisplayMenu() {
        // Redirect standard output to capture the printed menu
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        cateringService.displayMenu();

        String menuOutput = outputStream.toString();
        assertTrue(menuOutput.contains("Menu Items:"));
        assertTrue(menuOutput.contains("- Chicken Alfredo"));
        assertTrue(menuOutput.contains("- Vegetable Stir-Fry"));
        assertTrue(menuOutput.contains("- Beef Tacos"));
        assertTrue(menuOutput.contains("- Fruit Salad"));

        // Reset the standard output
        System.setOut(System.out);
    }

    @Test
    public void testIsItemAvailable() {
        String existingItem = "Beef Tacos";
        String nonExistingItem = "Pasta";
        assertTrue(cateringService.isItemAvailable(existingItem));
        assertFalse(cateringService.isItemAvailable(nonExistingItem));
    }

    @Test
    public void testCalculateOrderTotal() {
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Chicken Alfredo");
        orderItems.add("Vegetable Stir-Fry");
        double totalCost = cateringService.calculateOrderTotal(orderItems);
        assertEquals(20.0, totalCost, 0.01);
    }

    @Test
    public void testIsDiscountEligible() {
        double totalCostBelowThreshold = 40.0;
        double totalCostAtThreshold = 50.0;
        double totalCostAboveThreshold = 60.0;

        assertFalse(cateringService.isDiscountEligible(totalCostBelowThreshold));
        assertTrue(cateringService.isDiscountEligible(totalCostAtThreshold));
        assertTrue(cateringService.isDiscountEligible(totalCostAboveThreshold));
    }

    @Test
    public void testApplyDiscount() {
        double totalCostBelowThreshold = 40.0;
        double totalCostAtThreshold = 50.0;
        double totalCostAboveThreshold = 60.0;

        double finalCostBelowThreshold = cateringService.applyDiscount(totalCostBelowThreshold);
        double finalCostAtThreshold = cateringService.applyDiscount(totalCostAtThreshold);
        double finalCostAboveThreshold = cateringService.applyDiscount(totalCostAboveThreshold);

        assertEquals(40.0, finalCostBelowThreshold, 0.01);
        assertEquals(45.0, finalCostAtThreshold, 0.01);
        assertEquals(54.0, finalCostAboveThreshold, 0.01);
    }

    @Test
    public void testProcessOrder() {
        List<String> orderItems = new ArrayList<>();
        orderItems.add("Chicken Alfredo");
        orderItems.add("Vegetable Stir-Fry");

        // Redirect standard output to capture the printed order details
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        cateringService.processOrder(orderItems);

        String orderOutput = outputStream.toString();
        assertTrue(orderOutput.contains("Total Cost (Before Discount): $20.0"));
        assertTrue(orderOutput.contains("Final Cost (After Discount): $20.0"));

        // Reset the standard output
        System.setOut(System.out);
    }
}
