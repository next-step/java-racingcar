package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    PLUS("+" , (a , b) -> a + b),
    MINUS("-" , (a , b) -> a - b),
    TIMES("*" , (a , b) -> a * b),
    DIVIDE("/" , (a , b) -> a / b);

    private final String sign;
    private final IntBinaryOperator functionalInterface;

    Operator(String sign, IntBinaryOperator functionalInterface) {
        this.sign = sign;
        this.functionalInterface = functionalInterface;
    }

    public static Operator valueOfOperator(String operator) {
        return Arrays.stream(values()).filter(op -> op.sign.equals(operator)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int apply(int a, int b) {
        return functionalInterface.applyAsInt(a, b);
    }
}
