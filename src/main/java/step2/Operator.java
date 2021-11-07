package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> { return first.plus(second); }),
    MINUS("-", (first, second) -> { return first.minus(second); }),
    MULTIPLY("*", (first, second) -> { return first.multiply(second); }),
    DIVIDE("/", (first, second) -> { return first.divide(second); });

    private String operator;
    private BiFunction<MyNumber, MyNumber, MyNumber> operation;

    Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(MyException.INVALID_OPERATOR.getMessage()));
    }

    public MyNumber apply(MyNumber first, MyNumber second) {
        return operation.apply(first, second);
    }
}
