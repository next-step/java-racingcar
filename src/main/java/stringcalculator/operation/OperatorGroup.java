package stringcalculator.operation;

import java.util.Arrays;

public enum OperatorGroup {
    PLUS("+", (Double::sum)),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    MODIFY("/", (x, y) -> x / y);

    private String type;
    private Operator operator;

    OperatorGroup(String type, Operator operator) {
        this.type = type;
        this.operator = operator;
    }

    public static OperatorGroup findOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.isEqual(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 아닙니다."));
    }

    public Double operate(Double x, Double y) {
        return this.operator.excute(x, y);
    }

    private boolean isEqual(String operator) {
        return this.type.equals(operator);
    }
}
