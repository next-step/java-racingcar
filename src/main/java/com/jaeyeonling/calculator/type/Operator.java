package com.jaeyeonling.calculator.type;


import com.jaeyeonling.calculator.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Operator {
    
    ADD("+") {
        @Override
        public int apply(int a, int b) {
            return calculator.add(a, b);
        }
    },
    SUBTRACT("-") {
        @Override
        public int apply(int a, int b) {
            return calculator.subtract(a, b);
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int a, int b) {
            return calculator.multiply(a, b);
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int a, int b) {
            return calculator.divide(a, b);
        }
    };

    //
    //
    //

    private static final Calculator calculator = new Calculator();

    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        for (final Operator operator : values()) {
            operatorMap.put(operator.symbol, operator);
        }
    }

    private final String symbol;

    //
    //
    //

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    //
    //
    //

    public abstract int apply(int a, int b);

    public static Operator of(final String symbol) {
        final Operator operator = operatorMap.get(symbol);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException();
        }

        return operator;
    }
}
