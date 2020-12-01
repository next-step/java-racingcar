package com.nextstep.calculator.domain;

public class Number {
    private final int value;

    public Number(final String number) {
        this.value = Integer.parseInt(number);
    }
}
