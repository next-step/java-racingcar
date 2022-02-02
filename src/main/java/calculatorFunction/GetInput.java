package calculatorFunction;

import java.util.Scanner;
import java.util.ArrayList;

public class GetInput {

    public static String inputString() {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        expression = expression.replace(" ", "");
        return expression;
    }

    public static ArrayList<String> parse(String expression) {
        ArrayList<String> parsedExpression = new ArrayList<>();
        parsedExpression.add(getInteger(expression, 0));
        int operatorIdx = parsedExpression.get(0).length();

        while (operatorIdx != expression.length()) {
            parsedExpression.add(getString(expression, operatorIdx));
            operatorIdx++;
            parsedExpression.add(getInteger(expression, operatorIdx));
            operatorIdx += parsedExpression.get(parsedExpression.size() - 1).length();
        }
        return parsedExpression;
    }

    public static String getInteger(String expression, int idx) {
        StringBuilder string = new StringBuilder();
        for (int i = idx; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                string.append(expression.charAt(i));
            } else {
                break;
            }
        }
        if (string.length() == 0) {
            throw new IllegalArgumentException("Error: need right expression");
        } else if (string.charAt(0) == '0' && string.length() > 1) {
            throw new IllegalArgumentException("Error: need right operand");
        }

        return string.toString();
    }

    public static String getString(String expression, int idx) {
        return Character.toString(expression.charAt(idx));
    }
}
