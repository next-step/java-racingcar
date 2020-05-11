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

    public static Operator select(String stringOperator) {
        if ("+".equals(stringOperator)) return PLUS;
        if ("-".equals(stringOperator)) return MINUS;
        if ("*".equals(stringOperator)) return MULTIPLY;
        if ("/".equals(stringOperator)) return DIVIDE;
        throw new IllegalArgumentException();
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculator.calculate(firstValue, secondValue);
    }
}
