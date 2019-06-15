package com.jaeyeonling.calculator.type;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntBinaryOperator;

public enum Operator {
    
    ADD("+", Integer::sum),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        for (final Operator operator : values()) {
            operatorMap.put(operator.symbol, operator);
        }
    }

    private final String symbol;
    private IntBinaryOperator calculator;

    Operator(final String symbol, final IntBinaryOperator calculator) {

        this.symbol = symbol;
        this.calculator = calculator;
    }

    public static Operator symbol(final String symbol) {
        final Operator operator = operatorMap.get(symbol);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException("지원하지 않는 Symbol");
        }

        return operator;
    }

    public int apply(int num1, int num2) {
        return calculator.applyAsInt(num1, num2);
    }
}
