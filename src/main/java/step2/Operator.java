package step2;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String sign;
    private final BinaryOperator<Integer> op;

    Operator(String sign, BinaryOperator<Integer> op) {
        this.sign = sign;
        this.op = op;
    }

    public static Operator withSign(final String sign) {
        return Arrays.stream(Operator.values())
                .filter(o -> sign.equalsIgnoreCase(o.sign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 사칙연산 기호 입니다."));
    }

    public int operate(int a, int b) {
        return op.apply(a, b);
    }
}
