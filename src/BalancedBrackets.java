import java.util.Stack;

import java.util.Scanner;

public class BalancedBrackets {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] expression = new String[t];
        for (int tItr = 0; tItr < t; tItr++) {
            expression[tItr] = scanner.nextLine();
        }

        for (String s : expression) {
            System.out.println(isBalanced(s) ? "YES" : "NO");
        }
        scanner.close();


    }

    public static boolean isBalanced(String expression) {

        char[] chars = expression.toCharArray();
        Stack s = new Stack();

        for (char c: chars) {
            // Opening brackets push in the stack
            if (c == '{' || c == '[' || c == '(') {
                s.push(c);
            }
            // Closing brackets pop from the stack and compare
            else if (c == '}' || c == ']' || c == ')') {

                if (s.empty())
                    return false;
                char t = (char)s.pop();

                if (!(((t == '{')&&(c == '}')) ||
                        ((t == '[') && (c == ']')) ||
                        ((t == '(') && (c == ')'))))
                    return false;
            }
        }

        if (s.empty())
            return true;
        else
            return false;
    }
}
