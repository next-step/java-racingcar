package step2.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String value;

    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String value, BiFunction<Integer, Integer, Integer> operation) {
        this.value = value;
        this.operation = operation;
    }

    public static Operator of(String operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.value.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public static boolean contains(String operator) {
        return Arrays.stream(Operator.values())
                .anyMatch(op -> op.value.equals(operator));
    }

    public int calculate(Integer firstNumber, Integer secondNumber) {
        return this.operation.apply(firstNumber, secondNumber);
    }
}
