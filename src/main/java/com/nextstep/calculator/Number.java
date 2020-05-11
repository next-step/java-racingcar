package com.nextstep.calculator;

import java.util.Objects;

public class Number {
    private final int value;

    private Number(String value) {
        this.value = Integer.parseInt(value);
    }

    private Number(int value) {
        this.value = value;
    }

    public static Number stringToNumber(String inputString) {
        return new Number(inputString);
    }

    public static Number intToNumber(int inputInt) {
        return new Number(inputInt);
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
