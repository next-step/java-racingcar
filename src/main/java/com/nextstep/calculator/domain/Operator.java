package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidOperatorException;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (Number first, Number second) -> first.getValue() + second.getValue()),
    MINUS("-", (Number first, Number second) -> first.getValue() - second.getValue()),
    DIVIDE("/", (Number first, Number second) -> first.getValue() / second.getValue()),
    MULTIPLY("*", (Number first, Number second) -> first.getValue() * second.getValue());

    private final String value;
    private final Calculate calculate;

    Operator(String value, Calculate calculate) {
        this.value = value;
        this.calculate = calculate;
    }

    public static Operator of(String value) {
        return Arrays.stream(Operator.values())
                .filter((Operator operator) -> operator.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 사칙연산 인자입니다."));
    }

    public int operate(Number fist, Number second) {
        return calculate.calculate(fist, second);
    }
}
