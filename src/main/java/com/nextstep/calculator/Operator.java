package com.nextstep.calculator;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> {
        if (a % b != 0) {
            throw new IllegalArgumentException(a + " can't divided into " + b);
        }
        return a / b;
    })
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator select(String symbol) {
        return Stream.of(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public int apply(int a, int b) {
        return function.apply(a,b);
    }
}
