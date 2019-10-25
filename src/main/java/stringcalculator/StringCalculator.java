package stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private String[] availablePattern = new String[]{"^[0-9]*$", "^(\\+|\\-|\\*|\\/)$"};

    public int plus(int operand1, int operand2) {
        return operand1 + operand2;
    }

    public int minus(int operand1, int operand2) {
        return operand1 - operand2;
    }

    public int multiply(int operand1, int operand2) {
        return operand1 * operand2;
    }

    public int divide(int operand1, int operand2) {
        return operand1 / operand2;
    }

    public void validate(String expression) {
        checkWhetherEmpty(expression);

        String[] seperatedExpression = expression.split(" ");

        if (seperatedExpression.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < seperatedExpression.length; i++) {
            matches(availablePattern[i % 2], seperatedExpression[i]);
        }
    }

    private void checkWhetherEmpty(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void matches(String availablePattern, CharSequence input) {
        if (!Pattern.matches(availablePattern, input)) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate(String expression) {
        String[] seperatedExpression = expression.split(" ");

        int result = Integer.parseInt(seperatedExpression[0]);

        for (int i = 0; i < seperatedExpression.length / 2; i++) {
            result = operate(result, Integer.parseInt(seperatedExpression[i * 2 + 2]), seperatedExpression[i * 2 + 1]);
        }

        return result;
    }

    private int operate(int operand1, int operand2, String operator) {
        if (operator.equals("+")) {
            return plus(operand1, operand2);
        }

        if (operator.equals("-")) {
            return minus(operand1, operand2);
        }

        if (operator.equals("*")) {
            return multiply(operand1, operand2);
        }

        return divide(operand1, operand2);
    }
}