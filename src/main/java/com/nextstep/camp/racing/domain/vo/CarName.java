package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.domain.exception.CarNameCannotBeBlankException;
import com.nextstep.camp.racing.domain.exception.CarNameTooLongException;

public class CarName {

    private final String value;

    private static final int MAX_LENGTH = 5;

    private CarName(String value) {
        validate(value);
        this.value = value;
    }

    public static CarName of(String value) {
        return new CarName(value);
    }

    private static void validate(String name) {
        if (name.isBlank()) {
            throw new CarNameCannotBeBlankException();
        }
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new CarNameTooLongException();
        }
    }

    public String getValue() {
        return this.value;
    }
}
