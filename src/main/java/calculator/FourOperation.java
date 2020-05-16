package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum FourOperation {
    PLUS("+" , (a , b) -> a + b),
    MINUS("-" , (a , b) -> a - b),
    TIMES("*" , (a , b) -> a * b),
    DIVIDE("/" , (a , b) -> a / b);

    private final String operator;
    private final IntBinaryOperator op;

    FourOperation(String operator, IntBinaryOperator op) {
        this.operator = operator;
        this.op = op;
    }

    public static FourOperation valueOfOperator(String operator) {
        return Arrays.stream(values()).filter(fourOperation -> fourOperation.operator.equals(operator)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int apply(int a, int b) {
        return op.applyAsInt(a, b);
    }
}
