package step2;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVIDE("/", (a, b) -> b == 0 ? 0 : a / b),
    MULTIPLY("*", (a, b) -> a * b);

    private final String expression;
    private final IntBinaryOperator operator;

    Operator(String expression, IntBinaryOperator intBinaryOperator) {
        this.expression = expression;
        this.operator = intBinaryOperator;
    }

    public static Operator from(final String expression) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.expression.equals(expression))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("'%s'사칙연산 기호가 올바르지 않습니다.", expression)));
    }

    public int result(String left, String right) {
        return this.result(Integer.parseInt(left), Integer.parseInt(right));
    }

    public int result(int left, int right) {
        return this.operator.applyAsInt(left, right);
    }
}
