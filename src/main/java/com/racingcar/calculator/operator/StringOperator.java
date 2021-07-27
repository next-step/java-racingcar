package com.racingcar.calculator.operator;

public class StringOperator implements Operator {
    @Override
    public int add(int value1, int value2) {
        return value1 + value2;
    }

    @Override
    public int subtract(int value1, int value2) {
        return value1 - value2;
    }

    @Override
    public int divide(int value1, int value2) {
        return value1 / value2;
    }

    @Override
    public int multiply(int value1, int value2) {
        return value1 * value2;
    }
}
