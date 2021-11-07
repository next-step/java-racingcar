package study02;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * .
 */
public enum Operator {
    ADDITION("+", (left, right) -> left.plus(right)),
    SUBTRACTION("-", (left, right) -> left.minus(right)),
    MULTIPLICATION("*", (left, right) -> left.times(right)),
    DIVISION("/", (left, right) -> left.dividedBy(right));

    private String operator;
    private BiFunction<MyNumber, MyNumber, MyNumber> operation;

    Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public MyNumber operate(MyNumber first, MyNumber second) {
        return operation.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
