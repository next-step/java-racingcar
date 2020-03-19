package calculator;

import calculator.operand.Number;

import java.util.Stack;

public class StringCalculator {
    private static final String BLANK = " ";
    public int calculate(String input) {
        isEmpty(input);

        String[] source = toStringArray(input);
        Stack<Number> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        int result = 0;

        for (String value : source) {
            // 피연산자
            if (isNumber(value)) {
                operandStack.push(Number.intValueOf(value));
            }

            // 연산자
            if (isOperator(value)) {
                operatorStack.push(value);
            }

            // 사칙연산
            if (operandStack.size() == 2 && operatorStack.size() == 1) {
                Number otherNumber = operandStack.pop();
                Number number = operandStack.pop();
                String operatorText = operatorStack.pop();
                if ("+".equals(operatorText)) {
                    result = number.plus(otherNumber).getValue();
                } else if ("-".equals(operatorText)) {
                    result = number.minus(otherNumber).getValue();
                } else if ("*".equals(operatorText)) {
                    result = number.multiple(otherNumber).getValue();
                }
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

    public boolean isOperator(final String value) {
        return "+".equals(value) || "-".equals(value) || "*".equals(value) || "/".equals(value);
    }
}
