package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum  Operator {
    PULS ("+", (first, second) -> first + second),
    MINUS ("-", (first, second) -> first - second),
    MULTIPLY ("*", (first, second) -> first * second),
    DIVIDED ("/", (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return first / second;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int operate(int first, String operator, int second) {
        return findOperator(operator).expression.apply(first, second);
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }
}