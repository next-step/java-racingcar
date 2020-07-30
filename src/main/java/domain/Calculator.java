package domain;

import constant.ExceptionMessage;

public class Calculator {

    private final String expression;

    public Calculator() {
        throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_IS_EMPTY);
    }

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_IS_EMPTY);
        }
        this.expression = expression;
    }

    public int calculate() {
        String[] splitExpression = expression.split(" ");
        int number = Integer.parseInt(splitExpression[0]);

        for (int i = 1; i < splitExpression.length; i = i + 2) {
            Operation operation = Operation.findOperation(splitExpression[i]);
            number = operation.compute(number, Integer.parseInt(splitExpression[i + 1]));
        }
        return number;
    }
}
