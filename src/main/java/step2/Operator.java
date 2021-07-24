package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    }),
    ;

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(int first, int second) {
        return expression.apply(first, second);
    }

    public static Operator find(String operator) {
        return Arrays.stream(values())
                .filter(v -> operator.equals(v.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산자가 아닙니다", operator)));
    }
}
