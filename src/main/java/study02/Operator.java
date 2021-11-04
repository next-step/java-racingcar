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
    private BiFunction<CustomNumber, CustomNumber, CustomNumber> operation;

    Operator(String operator, BiFunction<CustomNumber, CustomNumber, CustomNumber> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public CustomNumber operate(CustomNumber first, CustomNumber second) {
        return operation.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
