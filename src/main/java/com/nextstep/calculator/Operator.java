package com.nextstep.calculator;

public enum Operator {
    PLUS(
            "+",
            (firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() + secondNumber.value())
    ),
    MINUS(
            "-",
            (firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() - secondNumber.value())
    ),
    MULTIPLY(
            "*",
            (firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() * secondNumber.value())
    ),
    DIVIDE(
            "/",
            (firstNumber, secondNumber) -> Number.intToNumber(firstNumber.value() / secondNumber.value())
    );

    private String operator;
    private Calculator calculator;

    Operator(String operator, Calculator calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    private String getStringOperator() {
        return this.operator;
    }

    public static Operator select(String stringOperator) {
        if (PLUS.getStringOperator().equals(stringOperator)) return PLUS;
        if (MINUS.getStringOperator().equals(stringOperator)) return MINUS;
        if (MULTIPLY.getStringOperator().equals(stringOperator)) return MULTIPLY;
        if (DIVIDE.getStringOperator().equals(stringOperator)) return DIVIDE;
        throw new IllegalArgumentException();
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculator.calculate(firstValue, secondValue);
    }
}
