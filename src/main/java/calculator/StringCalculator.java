package calculator;

import java.util.function.BinaryOperator;

public class StringCalculator {

    private int result;
    private String[] splitExpression;

    public int calculate(String expression) {
        validateInput(expression);

        splitExpression = expression.split(" ");
        result = Integer.parseInt(splitExpression[0]);

        for (int idx = 1; idx < splitExpression.length; idx += 2) {
            calculateOneByOne(idx);
        }

        return result;
    }

    private void calculateOneByOne(int idx) {
        BinaryOperator<Integer> calculateFunction = distinguishOperator(splitExpression[idx]);
        int operand = Integer.parseInt(splitExpression[idx + 1]);

        result = calculateFunction.apply(result, operand);
    }

    private void validateInput(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("입력은 공백이면 안됩니다.");
        }
    }

    private BinaryOperator<Integer> distinguishOperator(String operator) {
        if (operator.equals("+")) {
            return add();
        }
        if (operator.equals("-")) {
            return subtract();
        }
        if (operator.equals("*")) {
            return multiply();
        }
        if (operator.equals("/")) {
            return divide();
        }
        throw new IllegalArgumentException("사칙 연산 기호가 아닙니다.");
    }

    private BinaryOperator<Integer> add() {
        return (a, b) -> a + b;
    }

    private BinaryOperator<Integer> subtract() {
        return (a, b) -> a - b;
    }

    private BinaryOperator<Integer> multiply() {
        return (a, b) -> a * b;
    }

    private BinaryOperator<Integer> divide() {
        return (a, b) -> {
            validateDenominator(a, b);
            return a / b;
        };
    }

    private void validateDenominator(Integer a, Integer b) {
        if (b == 0) {
            throw new ArithmeticException("나눗셈의 분모는 0이면 안됩니다.");
        }
    }

}
