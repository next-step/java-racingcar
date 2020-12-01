package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidNumberException;

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
}
