package com.nextstep.calculator;

public enum Operator {
    PLUS(Number::plus);

    private Calculate calculate;

    Operator(Calculate calculate) {
        this.calculate = calculate;
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculate.calculate(firstValue, secondValue);
    }
}
