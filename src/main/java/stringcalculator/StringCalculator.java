package stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private final Pattern availableOperandPattern = Pattern.compile("^[0-9]*$");
    private final Pattern availableOperatorPattern = Pattern.compile("^(\\+|\\-|\\*|\\/)$");
    private final Pattern[] availablePattern = new Pattern[]{availableOperandPattern, availableOperatorPattern};
    private String[] seperatedExpression;

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

        seperatedExpression = expression.split(" ");

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

    private void matches(Pattern availablePattern, CharSequence input) {
        if (!availablePattern.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public int calculate() {
        if (seperatedExpression == null) {
            throw new IllegalArgumentException();
        }

        int result = Integer.parseInt(seperatedExpression[0]);

        int operationCount = seperatedExpression.length / 2;
        for (int i = 0; i < operationCount; i++) {
            result = operate(result, getNextOperand(i), getOperator(i));
        }

        return result;
    }

    private String getOperator(int index) {
        return seperatedExpression[index * 2 + 1];
    }

    private int getNextOperand(int index) {
        return Integer.parseInt(seperatedExpression[index * 2 + 2]);
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