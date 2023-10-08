// Main class to call methods
public class Main {
    public static void main(String[] args) {
        MathOperations mathOps = new MathOperations();
        StringManipulation strOps = new StringManipulation();

        // Call methods from MathOperations
        System.out.println("Addition: " + mathOps.add(5, 3));
        System.out.println("Subtraction: " + mathOps.subtract(10, 4));
        System.out.println("Multiplication: " + mathOps.multiply(6, -2));
        System.out.println("Division: " + mathOps.divide(12, 5));

        // Call methods from StringManipulation
        System.out.println("Concatenation: " + strOps.concatenate("Hello, ", "World!"));
        System.out.println("Contains Character 'o': " + strOps.containsCharacter("Hello", 'o'));
        System.out.println("Reversed String: " + strOps.reverseString("Java"));
        System.out.println("Is Palindrome: " + strOps.isPalindrome("racecar"));
        System.out.println("Count Vowels: " + strOps.countVowels("OpenAI GPT-3.5"));
        System.out.println("Is Empty: " + strOps.isEmpty(""));
    }
}