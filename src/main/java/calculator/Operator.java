package calculator;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String operator;
    private final Operation operation;

    Operator(String operator, Operation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operator of(String value) {
        return Arrays.stream(values())
                     .filter(o -> o.operator.equals(value))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int first, int second) {
        return operation.operate(first, second);
    }
}
