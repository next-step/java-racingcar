package com.nextstep.calculator.domain;

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
                .orElseThrow(IllegalArgumentException::new);
    }
}
