package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class StringParsing {

    private static List<Operand> operandList;
    private static List<Operation> operationList;

    public StringParsing(String[] splitExpression) {
        operandList = new ArrayList<>();
        operationList = new ArrayList<>();
        validateIdleExpression(splitExpression);
        splitOperationOperand(splitExpression);
    }

    private void splitOperationOperand(String[] splitExpression) {
        for (int index = 1; index < splitExpression.length; index += 2) {
            operationList.add(new Operation(splitExpression[index]));
            operandList.add(new Operand(splitExpression[index-1]));
        }
        operandList.add(new Operand(splitExpression[splitExpression.length-1]));
    }

    private void validateIdleExpression(String[] splitExpression) {
        if (splitExpression.length % 2 == 0) {
            throw new IllegalArgumentException("[ERROR] 올바른 수식이 아닙니다");
        }
    }

    public List<Operand> getOperandList() {
        return operandList;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

}
