package com.nextstep.calculator;

public class Number {
    private final int value;

    private Number(String value) {
        this.value = Integer.parseInt(value);
    }

    public static Number stringToNumber(String inputString) {
        return new Number(inputString);
    }

    public int value() {
        return this.value;
    }
}
