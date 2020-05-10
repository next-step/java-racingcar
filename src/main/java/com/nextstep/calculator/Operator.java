package com.nextstep.calculator;

public enum Operator {
    PLUS(Number::plus);

    private Calculator calculator;

    Operator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculator.calculate(firstValue, secondValue);
    }
}
