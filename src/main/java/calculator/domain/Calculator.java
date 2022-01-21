package calculator.domain;

import calculator.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final int INTERVAL_OF_INDEX = 2;
    private static final int START_OPERAND_INDEX = 0;
    private static final int START_OPERATION_INDEX = 1;
    private static final int INTERVAL_OF_NUMBER_INDEX = 1;

    private List<Operand> operandList;
    private List<Operation> operationList;

    public Calculator() {
        operandList = new ArrayList<>();
        operationList = new ArrayList<>();
    }

    public int calculate(String expression) {
        String[] splitExpression = StringUtils.splitExpression(expression);
        validateIdleExpression(splitExpression);
        extractOperand(splitExpression);
        extractOPeration(splitExpression);
        calculateExpression();
        return operandList.get(operandList.size() - 1)
            .getNumber();
    }

    private void calculateExpression() {
        Operand left = operandList.get(START_OPERAND_INDEX);
        for (int index = START_OPERAND_INDEX; index < operationList.size(); index++) {
            Operation operation = operationList.get(index);
            Operand right = operandList.get(index + INTERVAL_OF_NUMBER_INDEX);
            left = new Operand(operation.operate(left, right));
        }
        operandList.add(left);
    }

    private void extractOPeration(String[] splitExpression) {
        for (int index = START_OPERATION_INDEX; index < splitExpression.length; index += INTERVAL_OF_INDEX) {
            operationList.add(new Operation(splitExpression[index]));
        }
    }

    private void extractOperand(String[] splitExpression) {
        for (int index = 0; index < splitExpression.length; index += INTERVAL_OF_INDEX) {
            operandList.add(new Operand(splitExpression[index]));
        }
    }

    private void validateIdleExpression(String[] splitExpression) {
        if (splitExpression.length % 2 == 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 수식이 아닙니다");
        }
    }
}
