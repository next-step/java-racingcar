package stringcalculator;

import java.util.Arrays;

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

    public static Operation of(String operation) {
        return Arrays.stream(values())
                .filter(op -> op.isEqual(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(operation +"은 연산자가 아닙니다"));
    }

    private boolean isEqual(String operation) {
        return this.operation.equals(operation);
    }

    public double operate(double leftNumber, double rightNumber) {
        return operationInterface.operate(leftNumber,rightNumber);
    }
}
