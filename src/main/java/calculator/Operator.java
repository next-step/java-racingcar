package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (no1, no2) -> no1 + no2),
    MINUS("-", (no1, no2) -> no1 - no2),
    MULTIPLY("*", (no1, no2) -> no1 * no2),
    DIVIDE("/", (no1, no2) -> {
        if (no2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return no1 / no2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 잘못 입력 되었습니다."));
    }

    public int calculate(int first, int second) {
        return expression.apply(first, second);
    }
}
