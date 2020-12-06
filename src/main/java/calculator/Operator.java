package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;


public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return x / y;
    });


    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator valueOfOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.operator.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 올바르지 않습니다."));
    }

    public Integer caculate(int x, int y) {
        return expression.apply(x, y);
    }



}
