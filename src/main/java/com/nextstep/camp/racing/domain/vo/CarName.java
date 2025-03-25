package com.nextstep.camp.racing.domain.vo;

import com.nextstep.camp.racing.domain.exception.CarNameCannotBeBlankException;
import com.nextstep.camp.racing.domain.exception.CarNameTooLongException;

public class CarName {
    private final String value;

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
        if (name.length() > 5) {
            throw new CarNameTooLongException();
        }
    }

    public String getValue() {
        return value;
    }
}
