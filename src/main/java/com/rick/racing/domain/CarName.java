package com.rick.racing.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL_OR_EMPTY = "자동차 이름은 null이거나 빈 값일 수 없습니다.";

    private final String value;

    private CarName(final String name) {
        this.value = name;
    }

    public static CarName create(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL_OR_EMPTY);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MINIMUM_CAR_NAME_LENGTH);
        }

        return new CarName(name);
    }

    @Override
    public boolean equals(final Object target) {
        if (this == target) {
            return true;
        }
        if (target == null || getClass() != target.getClass()) {
            return false;
        }
        CarName carName = (CarName) target;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }
}
