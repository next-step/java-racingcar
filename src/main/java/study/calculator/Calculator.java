package study.calculator;

import java.util.Objects;

public class Calculator {
    private static final String DELIMITER = " ";

    public float calculate(String expression) {
        validate(expression);

        String[] parts = expression.trim().split(DELIMITER);
        if (parts.length < 3) {
            throw new IllegalArgumentException();
        }
        float result = Float.parseFloat(parts[0]);
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

    private float operate(String stringOperator, float leftSide, float rightSide) {
        Operand operand = new Operand(leftSide, rightSide);
        Operator operator = Operator.symbolOf(stringOperator);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException();
        }
        return operator.run(operand);
    }
}
