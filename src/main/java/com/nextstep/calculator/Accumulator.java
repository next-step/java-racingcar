package com.nextstep.calculator;

public class Accumulator {
    private int value;

    public Accumulator(int init) {
        value = init;
    }

    public void calculate(String symbol, int number) {
        Operator operator = Operator.select(symbol);
        if (operator == null) {
            throw new IllegalArgumentException(symbol + " is not valid operator ( +, -, *, / )");
        }
        value = operator.apply(value, number);
    }

    public int getValue() {
        return value;
    }
}
