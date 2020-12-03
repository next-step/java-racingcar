package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidOperatorException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", (Number first, Number second) -> Number.of(first.getValue() + second.getValue())),
    MINUS("-", (Number first, Number second) -> Number.of(first.getValue() - second.getValue())),
    DIVIDE("/", (Number first, Number second) -> Number.of(first.getValue() / second.getValue())),
    MULTIPLY("*", (Number first, Number second) -> Number.of(first.getValue() * second.getValue()));

    private final String value;
    private final OperatorAction operatorAction;

    Operator(final String value, final OperatorAction operatorAction) {
        this.value = value;
        this.operatorAction = operatorAction;
    }

    public static Operator of(final String value) {
        return Arrays.stream(Operator.values())
                .filter((Operator operator) -> operator.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 사칙연산 인자입니다."));
    }

    public static boolean isOperator(final String target) {
        return Arrays.stream(Operator.values())
                .map(operator -> operator.value)
                .collect(Collectors.toList())
                .contains(target);
    }

    public Number operate(final Number first, final Number second) {
        return operatorAction.act(first, second);
    }
}
