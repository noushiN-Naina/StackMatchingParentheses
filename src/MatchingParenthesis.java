import java.util.*;


public class MatchingParenthesis {

    /**
     * Checks if all parentheses, curly braces in a string
     * are balanced and correctly nested using a Stack.
     *
     */
    public static boolean isParenthesesMatched(String str) {
        // We use a Stack to hold the opening delimiters encountered so far.
        Stack stack = new Stack(str.length());

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 1. If it's an opening delimiter, push it onto the stack.
            if (ch == '(' || ch == '{') {
                stack.push(ch);
            }
            // 2. If it's a closing delimiter
            else if (ch == ')' || ch == '}') {

                // Case 2a: Stack is empty. This means we found a closing delimiter
                // without a corresponding opening delimiter.
                if (stack.isEmpty()) {
                    return false;
                }

                // Case 2b: Pop the top element and check for a match.
                char top = stack.pop();

                // Check for mismatch
                if (ch == ')' && top != '(') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                }
            }

        }

        // 3. After iterating through the string, the stack must be empty.
        // If it's not empty, it means there are unmatched opening delimiters remaining.
        return stack.isEmpty();
    }

    /**
     * Main method to test the isParenthesesMatched function with various examples.
     */
    public static void main(String[] args) {
        String test1 = "{()}";
        String test2 = "({})";
        String test3 = "({)";
        String test4 = "{(}";

        System.out.println("--- Parentheses Matching Test Cases ---");

        // Test 1: Matched (True)
        boolean result1 = isParenthesesMatched(test1);
        System.out.printf("'%s' is matched: %b%n", test1, result1);

        // Test 2: Matched (True)
        boolean result2 = isParenthesesMatched(test2);
        System.out.printf("'%s' is matched: %b%n", test2, result2);

        // Test 3: Mismatched (False - incorrect nesting)
        boolean result3 = isParenthesesMatched(test3);
        System.out.printf("'%s' is matched: %b%n", test3, result3);

        // Test 4: Mismatched (False - wrong closing type)
        boolean result4 = isParenthesesMatched(test4);
        System.out.printf("'%s' is matched: %b%n", test4, result4);

    }
}