// Class 1: MathOperations
public class MathOperations {
    // Method 1: Add two numbers with if-else condition
    public int add(int a, int b) {
        if (b >= 0) {
            return a + b;
        } else {
            return a - Math.abs(b);
        }
    }

    // Method 2: Subtract two numbers with if-else condition
    public int subtract(int a, int b) {
        if (b >= 0) {
            return a - b;
        } else {
            return a + Math.abs(b);
        }
    }

    // Method 3: Multiply two numbers with for loop
    public int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < Math.abs(b); i++) {
            if (b < 0) {
                result -= a;
            } else {
                result += a;
            }
        }
        return result;
    }

    // Method 4: Divide two numbers with for loop and if-else condition
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        int remainder = Math.abs(a);
        int quotient = 0;
        while (remainder >= Math.abs(b)) {
            remainder -= Math.abs(b);
            quotient++;
        }

        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            quotient = -quotient;
        }

        return quotient;
    }
}