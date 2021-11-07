package study;

import study.operator.Operator;

public class Calculator {
    public static int calculate(String expression) {
        validate(expression);
        String[] splittedExpression = expression.split(" ");
        int firstOperand = Integer.parseInt(splittedExpression[0]);
        String operator = splittedExpression[1];
        int secondOperand = Integer.parseInt(splittedExpression[2]);

        return calculate(firstOperand, operator, secondOperand);
    }

    private static void validate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("expression must not null or empty. expression: " + expression);
        }
    }

    private static int calculate(int firstOperand, String operator, int secondOperand) {
        return Operator.findBy(operator).operate(firstOperand, secondOperand);
    }
}
