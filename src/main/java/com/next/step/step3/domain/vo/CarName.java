package com.next.step.step3.domain.vo;

import java.util.Objects;

public class CarName {

    private static final int MIN_CAR_NAME_LENGTH = 1;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    public String carName() {
        return name;
    }

    public void validateCarNameLength(String carName) {
        if (carName == null || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름의 최소 길이는 1글자입니다.");
        }
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름의 최대 길이는 5글자입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
