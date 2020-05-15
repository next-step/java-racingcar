package step2;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    });

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

    public int getResult(String leftOperand, String rightOperand) {
        return this.getResult(Integer.parseInt(leftOperand), Integer.parseInt(rightOperand));
    }

    public int getResult(int leftOperand, int rightOperand) {
        return this.operator.applyAsInt(leftOperand, rightOperand);
    }
}
