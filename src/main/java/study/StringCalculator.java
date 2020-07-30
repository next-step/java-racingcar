package study;

import java.util.Objects;

public class StringCalculator {

    private final String expression;

    public StringCalculator() {
        throw new IllegalArgumentException();
    }

    public StringCalculator(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.expression = expression;
    }

    public int calculate() {
        String[] splitExpression = expression.split(" ");
        int result = 0;

        for (int i = 2; i < splitExpression.length; i += 2) {
            if (i == 2) {
                result = Integer.parseInt(splitExpression[i - 2]);
            }

            int targetNumber = Integer.parseInt(splitExpression[i]);
            String operations = splitExpression[i - 1];

            ArithmeticOperations operation = ArithmeticOperations.of(operations);
            result = operation.calculate(result, targetNumber);
        }

        return result;
    }
}
