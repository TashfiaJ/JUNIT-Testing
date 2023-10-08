// Class 2: StringManipulation
public class StringManipulation {
    // Method 5: Concatenate two strings with if-else condition
    public String concatenate(String str1, String str2) {
        if (str1 == null) {
            return str2;
        } else if (str2 == null) {
            return str1;
        } else {
            return str1 + str2;
        }
    }

    // Method 6: Check if a string contains a specific character with for loop and if-else condition
    public boolean containsCharacter(String str, char c) {
        if (str == null) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    // Method 7: Reverse a string using a for loop
    public String reverseString(String str) {
        if (str == null) {
            return null;
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    // Method 8: Check if a string is a palindrome with if-else condition
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        String reversed = reverseString(str);
        return str.equals(reversed);
    }

    // Method 9: Count the number of vowels in a string with for loop
    public int countVowels(String str) {
        if (str == null) {
            return 0;
        }

        int count = 0;
        for (char c : str.toCharArray()) {
            if ("AEIOUaeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    // Method 10: Check if a string is empty with if-else condition
    public boolean isEmpty(String str) {
        if (str == null) {
            return true;
        } else {
            return str.isEmpty();
        }
    }
}