package com.nextstep.calculator;

public enum Operator {
    PLUS((firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() + secondNumber.value())),
    MINUS((firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() - secondNumber.value())),
    MULTIPLY((firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() * secondNumber.value())),
    DIVIDE((firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() / secondNumber.value()));

    private Calculator calculator;

    Operator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculator.calculate(firstValue, secondValue);
    }
}
