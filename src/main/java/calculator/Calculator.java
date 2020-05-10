package calculator;

import java.util.Objects;

public class Calculator {

    private Calculator() {
    }

    private static void validateExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] splitExpression = expression.split(" ");
        validateSplitLength(splitExpression);
        validateSplitExpression(splitExpression);
    }

    public static double calculate(String expression) {
        validateExpression(expression);

        String[] splitExpression = expression.split(" ");
        double result = Double.parseDouble(splitExpression[0]);
        for (int i = 1; i < splitExpression.length; i += 2) {
            Operator operator = Operator.findOperator(splitExpression[i]);
            result = operator.calculate(result, Double.parseDouble(splitExpression[i + 1]));
        }
        return result;
    }

    private static void validateSplitLength(String[] splitExpression) {
        if (splitExpression.length == 1 || splitExpression.length % 2 == 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateSplitExpression(String[] splitExpression) {
        for (int i = 0; i < splitExpression.length; i += 2) {
            Double.parseDouble(splitExpression[i]);
        }
    }
}
