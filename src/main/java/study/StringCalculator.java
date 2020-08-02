package study;

import java.util.Objects;

public class StringCalculator {

    private final String expression;

    private static final String SPLIT_EXPRESSION = " ";
    private static final int START_NUMBER = 1;

    public StringCalculator(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.expression = expression;
    }

    public int calculate() {
        String[] splitExpression = expression.split(SPLIT_EXPRESSION);
        validateExpression(splitExpression);

        int result = 0;

        for (int i = START_NUMBER; i < splitExpression.length; i += 2) {
            if (i == START_NUMBER) {
                result = Integer.parseInt(splitExpression[i - 1]);
            }

            int targetNumber = Integer.parseInt(splitExpression[i + 1]);
            String operations = splitExpression[i];

            ArithmeticOperations operation = ArithmeticOperations.of(operations);
            result = operation.calculate(result, targetNumber);
        }

        return result;
    }

    private void validateExpression(String[] expression) {
        if (expression.length < 3 || expression.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }
}
