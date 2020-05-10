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

    public int value() {
        return this.value;
    }

    public Number plus(Number number) {
        int resultValue = this.value + number.value();

        return new Number(resultValue);
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
