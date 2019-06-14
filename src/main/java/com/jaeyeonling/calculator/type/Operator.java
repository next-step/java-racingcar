package com.jaeyeonling.calculator.type;

import com.jaeyeonling.calculator.BiOperation;

public enum Operator {
    
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private final String symbol;
    private BiOperation<Integer> operation;

    Operator(final String symbol, final BiOperation<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    public String getSymbol() {
        return this.symbol;
    }

}
