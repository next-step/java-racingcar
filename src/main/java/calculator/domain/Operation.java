package calculator.domain;

import calculator.constant.ExceptionMessage;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operation {
    ADDITION("+", (prev, next) -> prev + next),
    SUBTRACTION("-", (prev, next) -> prev - next),
    MULTIPLICATION("*", (prev, next) -> prev * next),
    DIVISION("/", (prev, next) -> {
        if (next == 0) {
            throw new ArithmeticException(ExceptionMessage.DIVIDE_BY_ZERO);
        }
        return prev / next;
    });

    private final String symbol;
    private final IntBinaryOperator binaryOperator;

    Operation(String symbol, IntBinaryOperator binaryOperator) {
        this.symbol = symbol;
        this.binaryOperator = binaryOperator;
    }

    public int compute(int prev, int next) {
        return binaryOperator.applyAsInt(prev, next);
    }

    public static Operation findOperation(String symbol) {
        return Arrays.stream(values())
                .filter(operation -> operation.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.SYMBOL_NOT_ARITHMETIC));
    }
}
