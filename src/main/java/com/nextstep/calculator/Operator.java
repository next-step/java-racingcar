package com.nextstep.calculator;

import java.util.stream.Stream;

public enum Operator {
    ADDITION("+") {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(int a, int b) {
            if (a % b != 0) {
                throw new IllegalArgumentException(a + " can't divided into " + b);
            }
            return a / b;
        }
    }
    ;

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator select(String symbol) {
        return Stream.of(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElse(null);
    }

    public abstract int apply(int a, int b);
}
