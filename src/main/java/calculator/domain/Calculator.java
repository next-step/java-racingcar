package calculator.domain;

import calculator.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Operand> operandList;
    private List<Operation> operationList;

    public Calculator() {
        operandList = new ArrayList<>();
        operationList = new ArrayList<>();
    }

    public int calculate(String expression) {
        String[] splitExpression = StringUtils.splitExpression(expression);
        validateIdleExpression(splitExpression);
        validateOperand(splitExpression);
        validateOperation(splitExpression);
        return 0;
    }

    private void validateOperation(String[] splitExpression) {
        for (int index = 1; index < splitExpression.length; index += 2) {
            operationList.add(new Operation(splitExpression[index]));
        }
    }

    private void validateOperand(String[] splitExpression) {
        for (int index = 0; index < splitExpression.length; index += 2) {
            operandList.add(new Operand(splitExpression[index]));
        }
    }

    private void validateIdleExpression(String[] splitExpression) {
        if (splitExpression.length % 2 == 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 수식이 아닙니다");
        }
    }
}
