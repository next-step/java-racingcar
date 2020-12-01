package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidOperatorException;

import java.util.Arrays;

public enum Operator {
    PLUS("+"), MINUS("-"), DIVIDE("/"), MULTIPLY("*");

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator of(String value) {
        return Arrays.stream(Operator.values())
                .filter((Operator operator) -> operator.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 사칙연산 인자입니다."));
    }
}
