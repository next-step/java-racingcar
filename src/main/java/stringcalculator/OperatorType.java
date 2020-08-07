package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    OperatorType(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    private String getOperator() {
        return operator;
    }

    public int calculate(int n1, int n2) {
        return expression.apply(n1, n2);
    }

    public static OperatorType getOperatorType(String key) {
        return Arrays.stream(values())
                .filter(o -> o.getOperator().equals(key))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }
}
