package step2;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String sign;
    private IntBinaryOperator operate;

    Operator(String sign, IntBinaryOperator operate) {
        this.sign = sign;
        this.operate = operate;
    }

    public static Operator of(final String sign) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.getSign().equals(sign))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getSign() {
        return sign;
    }

    public IntBinaryOperator getOperate() {
        return operate;
    }


}
