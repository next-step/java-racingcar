package study.calculator;

import java.util.Objects;

public class Calculator {
    private static final String DELIMITER = " ";

    public double calculate(String expression) {
        validate(expression);

        String[] parts = expression.split(DELIMITER);
        if (parts.length < 3) {
            throw new IllegalArgumentException();
        }
        double result = Float.parseFloat(parts[0]);
        for (int i = 2; i < parts.length; i = i + 2) {
            result = operate(parts[i - 1], result, Float.parseFloat(parts[i]));
        }

        return result;
    }

    private void validate(String expression) {
        if (Objects.isNull(expression)) {
            throw new IllegalArgumentException();
        }
        if (expression.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private double operate(String stringOperator, double leftSide,
                           double rightSide) {
        return Operator.symbolOf(stringOperator).run(leftSide, rightSide);
    }
}
