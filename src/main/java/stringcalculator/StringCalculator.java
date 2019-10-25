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

    public void input(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validate(String expression) {
        String[] seperatedExpression = expression.split(" ");

        if (seperatedExpression.length % 2 == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < seperatedExpression.length; i++) {
            matches(availablePattern[i % 2], seperatedExpression[i]);
        }
    }

    private void matches(String availablePattern, CharSequence input) {
        if (!Pattern.matches(availablePattern, input)) {
            throw new IllegalArgumentException();
        }
    }
}
