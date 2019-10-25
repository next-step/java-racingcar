package stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private String availableOperatorsPattern = "^(\\+|\\-|\\*|\\/)$";

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

    public void validateOperators(String expression) {
        String[] seperatedExpression = expression.split(" ");

        for (int i = 1; i < seperatedExpression.length; i += 2) {
            matches(availableOperatorsPattern, seperatedExpression[i]);
        }
    }

    private void matches(String availablePattern, CharSequence input) {
        if (!Pattern.matches(availablePattern, input)) {
            throw new IllegalArgumentException();
        }
    }
}
