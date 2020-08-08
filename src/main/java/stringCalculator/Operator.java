package stringCalculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final Op op;
    private final String operator;

    Operator(String operator, Op operation) {
        this.operator = operator;
        this.op = operation;
    }

    public static Operator of(String value){
        Optional<Operator> maybeOperator = Arrays.stream(values()).filter(o -> o.operator.equals(value)).findFirst();
        return maybeOperator.orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int first, int second){
        return op.operate(first, second);
    }
}
