package com.jaeyeonling.calculator.provider;

import com.jaeyeonling.calculator.type.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OperatorProvider {

    private static final Map<String, Operator> operatorMap = new HashMap<>();
    static {
        for (final Operator operator : Operator.values()) {
            operatorMap.put(operator.getSymbol(), operator);
        }
    }

    public Operator symbol(final String symbol) {
        final Operator operator = operatorMap.get(symbol);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException();
        }

        return operator;
    }
}
