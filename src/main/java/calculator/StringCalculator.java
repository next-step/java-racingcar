package calculator;

import calculator.operand.Number;
import calculator.operator.Operator;

import java.util.Stack;

public class StringCalculator {
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";
    private static final int START_CALCULATE_OPERAND_SIZE = 2;
    private static final int START_CALCULATE_OPERATOR_SIZE = 1;
    public int calculate(String input) {
        isEmpty(input);

        String[] source = toStringArray(input);
        Stack<Number> operandStack = new Stack<>();
        Stack<Operator> operatorStack = new Stack<>();

        // TODO : refactor INDENT 2
        for (String value : source) {
            // 피연산자
            if (Number.isNumber(value)) {
                operandStack.push(Number.intValueOf(value));
            }

            // 연산자
            if (Operator.isOperator(value)) {
                operatorStack.push(Operator.getOperator(value));
            }

            // 사칙연산
            if (operandStack.size() == START_CALCULATE_OPERAND_SIZE && operatorStack.size() == START_CALCULATE_OPERATOR_SIZE) {
                operandStack.push(operate(operandStack, operatorStack));
            }
        }
        return operandStack.pop().getValue();
    }

    private void isEmpty(final String input) {
        if (input == null || input.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("wrong input value");
        }
    }

    String[] toStringArray(final String input) {
        return input.split(BLANK);
    }

    private Number operate(final Stack<Number> operandStack, final Stack<Operator> operatorStack) {
        Number otherNumber = operandStack.pop();
        Number number = operandStack.pop();
        return number.calculate(operatorStack.pop(), otherNumber);
    }
}
