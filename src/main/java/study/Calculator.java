package study;

import study.operator.Operator;

public class Calculator {
    private static final String DELIMITER = " ";
    private static final int FIRST_OPERAND_INDEX = 0;

    private Calculator() {
        new AssertionError();
    }

    public static int calculate(String expression) {
        validateOrElseThrow(expression);
        String[] splittedExpression = expression.split(DELIMITER);

        int result = Integer.parseInt(splittedExpression[FIRST_OPERAND_INDEX]);

        for (int i = 1; i < splittedExpression.length - 1; i += 2) {
            Operator operator = Operator.findBy(splittedExpression[i]);
            int operand = Integer.parseInt(splittedExpression[i + 1]);

            result = operator.operate(result, operand);
        }
        return result;
    }

    private static void validateOrElseThrow(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("expression must not null or empty. expression: " + expression);
        }
    }
}
