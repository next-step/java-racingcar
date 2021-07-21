package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    ADDITION("+", (first, second) -> first + second),
    SUBTRACTION("-", (first, second) -> first - second),
    MULTIPLICATION("*", (first, second) -> first * second),
    DIVISION("/", (first, second) -> first / second),
    ;

    private final String value;
    private final BinaryOperator<Integer> operator;

    Operator(String value, BinaryOperator<Integer> operator) {
        this.value = value;
        this.operator = operator;
    }

    public static Operator of(String value) {
        return Arrays.stream(values())
                .filter(operator -> operator.has(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("존재하지 않는 연산자입니다. %s", value)));
    }

    private boolean has(String value) {
        return this.value.equals(value);
    }

    public int operate(int first, int second) {
        return this.operator.apply(first, second);
    }
}
