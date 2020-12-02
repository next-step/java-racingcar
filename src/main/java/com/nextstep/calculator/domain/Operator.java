package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidOperatorException;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (Number first, Number second) -> Number.of(first.getValue() + second.getValue())),
    MINUS("-", (Number first, Number second) -> Number.of(first.getValue() - second.getValue())),
    DIVIDE("/", (Number first, Number second) -> Number.of(first.getValue() / second.getValue())),
    MULTIPLY("*", (Number first, Number second) -> Number.of(first.getValue() * second.getValue()));

    private final String value;
    private final OperatorAction operatorAction;

    Operator(String value, OperatorAction operatorAction) {
        this.value = value;
        this.operatorAction = operatorAction;
    }

    public static Operator of(String value) {
        return Arrays.stream(Operator.values())
                .filter((Operator operator) -> operator.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 사칙연산 인자입니다."));
    }

    public Number operate(Number first, Number second) {
        return operatorAction.act(first, second);
    }
}
