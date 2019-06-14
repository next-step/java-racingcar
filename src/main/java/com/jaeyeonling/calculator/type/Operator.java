package com.jaeyeonling.calculator.type;

public enum Operator {
    
    ADD("+") {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT("-") {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int a, int b);

    public String getSymbol() {
        return this.symbol;
    }

}
