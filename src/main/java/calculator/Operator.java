package calculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String operator;
    private final Op op;

    Operator(String operator, Op operation) {
        this.operator = operator;
        this.op = operation;
    }

    public static Operator of(String value) {
        Optional<Operator> maybeOperation = Arrays.stream(values()).filter(o -> o.operator.equals(value)).findFirst();
        return maybeOperation.orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int first, int second) {
        return op.operate(first, second);
    }
}
