package calculator.domain;

import calculator.util.StringUtils;

public class Calculator {

    private static final int INTERVAL_OF_INDEX = 2;
    private static final int START_OPERAND_INDEX = 0;
    private static final int OPERATION_INDEX = 1;

    public Calculator() {
    }

    public int calculate(String expression) {
        String[] splitExpression = StringUtils.splitExpression(expression);
        validateIdleExpression(splitExpression);
        return calculateExpression(splitExpression);
    }

    private int calculateExpression(String[] expression) {
        Operand left = new Operand(expression[START_OPERAND_INDEX]);
        for (int index = START_OPERAND_INDEX; index < expression.length - INTERVAL_OF_INDEX; index += INTERVAL_OF_INDEX) {
            Operation operation = Operation.from(expression[index + OPERATION_INDEX]);
            Operand right = new Operand(expression[index + INTERVAL_OF_INDEX]);
            left = new Operand(operation.operate(left, right));
        }
        return left.getNumber();
    }

    private void validateIdleExpression(String[] splitExpression) {
        if (splitExpression.length % 2 == 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 수식이 아닙니다");
        }
    }
}
