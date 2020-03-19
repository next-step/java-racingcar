package calculator;

import calculator.operand.Number;

import java.util.Stack;

public class StringCalculator {
    private static final String BLANK = " ";
    public int calculate(String input) {
        isEmpty(input);

        String[] source = toStringArray(input);
        Stack<Number> operandStack = new Stack<>();
        int result = 0;

        for (String value : source) {
            // 피연산자
            if (isNumber(value)) {
                operandStack.push(Number.intValueOf(value));
            }
        }
        return result;
    }

    private void isEmpty(final String input) {
        if (input == null || input.equals(BLANK)) {
            throw new IllegalArgumentException("wrong input value");
        }
    }

    String[] toStringArray(final String input) {
        return input.split(BLANK);
    }

    public boolean isNumber(final String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
