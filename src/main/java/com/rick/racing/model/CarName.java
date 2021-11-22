package com.rick.racing.model;

import java.util.Objects;

public class CarName {

    public static final int MAX_NAME_LENGTH = 5;
    private static final String EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";

    private final String value;

    private CarName(final String name) {
        this.value = name;
    }

    public static CarName create(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH);
        }
        return new CarName(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
