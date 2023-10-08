import java.util.ArrayList;
import java.util.List;

// Class 1: CateringService
public class CateringService {
    private List<String> menu;

    public CateringService() {
        // Initialize the menu with some items
        menu = new ArrayList<>();
        menu.add("Chicken Alfredo");
        menu.add("Vegetable Stir-Fry");
        menu.add("Beef Tacos");
        menu.add("Fruit Salad");
    }

    // Method 1: Add an item to the menu with an if-else condition
    public void addItemToMenu(String item) {
        if (item != null && !item.isEmpty()) {
            menu.add(item);
        } else {
            System.out.println("Invalid item. Item not added to the menu.");
        }
    }

    // Method 2: Remove an item from the menu with an if-else condition
    public void removeItemFromMenu(String item) {
        if (menu.contains(item)) {
            menu.remove(item);
        } else {
            System.out.println("Item not found on the menu. No item removed.");
        }
    }

    // Method 3: Display the menu items using a for-each loop
    public void displayMenu() {
        System.out.println("Menu Items:");
        for (String item : menu) {
            System.out.println("- " + item);
        }
    }

    // Method 4: Check if a specific item is available on the menu with an if-else condition
    public boolean isItemAvailable(String item) {
        if (menu.contains(item)) {
            return true;
        } else {
            return false;
        }
    }

    // Method 5: Calculate the total cost of a catering order with a for loop
    public double calculateOrderTotal(List<String> orderItems) {
        double totalCost = 0.0;
        for (String item : orderItems) {
            if (menu.contains(item)) {
                totalCost += 10.0; // Assume each item costs $10
            }
        }
        return totalCost;
    }

    // Method 6: Check if an order is eligible for a discount with an if-else condition
    public boolean isDiscountEligible(double totalCost) {
        if (totalCost >= 50.0) {
            return true;
        } else {
            return false;
        }
    }

    // Method 7: Apply a discount to the order with an if-else condition
    public double applyDiscount(double totalCost) {
        if (isDiscountEligible(totalCost)) {
            return totalCost * 0.9; // Apply a 10% discount
        } else {
            return totalCost;
        }
    }

    // Method 8: Process a catering order and display the final cost
    public void processOrder(List<String> orderItems) {
        double totalCost = calculateOrderTotal(orderItems);
        double finalCost = applyDiscount(totalCost);

        System.out.println("Order Details:");
        System.out.println("Total Cost (Before Discount): $" + totalCost);
        System.out.println("Final Cost (After Discount): $" + finalCost);
    }
}