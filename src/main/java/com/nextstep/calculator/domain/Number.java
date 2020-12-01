package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;

import java.util.Objects;

public class Number {
    private final int value;

    Number(final int value) {
        this.value = value;
    }

    public static Number of(final String number){
        try {
            return new Number(Integer.parseInt(number));
        } catch (Exception e) {
            throw new InvalidNumberException("숫자로 적합하지 않은 문자열입니다.");
        }
    }

    public static Number of(final int value) {
        return new Number(value);
    }

    public int getValue() {
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
