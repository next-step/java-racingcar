package calculator.domain;

import java.util.Arrays;
import java.util.List;

public enum Operation {

    PLUS("+", (leftNumber, rightNumber) -> leftNumber + rightNumber),
    MINUS("-", (leftNumber, rightNumber) -> leftNumber - rightNumber),
    MULTIPLY("*", (leftNumber, rightNumber) -> leftNumber * rightNumber),
    DIVIDE("/", (leftNumber, rightNumber) -> leftNumber / rightNumber);

    private String operation;
    private OperationInterface operationInterface;

    Operation(String operation, OperationInterface operationInterface) {
        this.operation = operation;
        this.operationInterface = operationInterface;
    }

    public static Operation from(String operation) {
        return Arrays.stream(values())
            .filter(op -> op.isEqual(operation))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(operation + "은 연산자가 아닙니다"));
    }

    public boolean isEqual(String operation) {
        return this.operation.equals(operation);
    }

    public int operate(Operand left, Operand right) {
        return operationInterface.operate(left.getNumber(), right.getNumber());
    }
}
