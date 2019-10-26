package stringcalculator.operation;

import java.util.Arrays;

public enum OperatorGroup {
    PLUS("+", (Double::sum)),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    MODIFY("/", (x, y) -> x / y);

    private String operator;
    private OperationInterface operationInterface;

    OperatorGroup(String operator, OperationInterface operationInterface) {
        this.operator = operator;
        this.operationInterface = operationInterface;
    }

    public static OperatorGroup findOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.isEqual(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다."));
    }

    public Double operate(Double x, Double y) {
        return this.operationInterface.operate(x, y);
    }

    private boolean isEqual(String operator) {
        return this.operator.equals(operator);
    }
}
