package com.jaeyeonling.calculator.type;

import com.jaeyeonling.calculator.BiOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum Operator {
    
    ADD("+", Integer::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        for (final Operator operator : Operator.values()) {
            operatorMap.put(operator.symbol, operator);
        }
    }

    private final String symbol;
    private BiOperation<Integer> operation;

    Operator(final String symbol, final BiOperation<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator symbol(final String symbol) {
        final Operator operator = operatorMap.get(symbol);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("지원하지 않는 Symbol");
        }

        return operator;
    }

    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

}
