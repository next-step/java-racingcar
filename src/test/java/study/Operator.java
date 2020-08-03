package study;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADDITION("+", (prev, next) -> prev + next),
    SUBTRACTION("-", (prev, next) -> prev - next),
    MULTIPLICATION("*", (prev, next) -> prev * next),
    DIVISION("/", (prev, next) -> {
        if (next == 0) {
            throw new ArithmeticException("0으로 나누어 떨어질 수 없습니다.");
        }
        return prev / next;
    });

    private final String symbol;
    private final IntBinaryOperator operate;

    Operator(String symbol, IntBinaryOperator operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public int compute(int prev, int next) {
        return operate.applyAsInt(prev, next);
    }

    public static Operator findOperation(String symbol) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
