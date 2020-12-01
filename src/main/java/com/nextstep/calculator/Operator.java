package com.nextstep.calculator;

import java.util.Arrays;
import java.util.Optional;

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
        Optional<Operator> selected = Arrays.stream(Operator.values())
                .filter(op -> op.getStringOperator().equals(stringOperator))
                .findFirst();

        return selected.orElseThrow(IllegalArgumentException::new);
    }

    public Number operate(Number firstValue, Number secondValue) {
        return this.calculator.calculate(firstValue, secondValue);
    }
}
