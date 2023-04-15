package com.nextstep.racingcargame.core;

import java.util.Objects;

public class Name {

    private final String carName;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static final String TOO_LONG_NAME_MSG = "자동차 이름은 5자를 초과할 수 없습니다.";

    private static final String CAR_EMPTY_VALUE_MSG = "차 이름이 임력되지 않았습니다.";

    public Name(String carName) {
        if (carNameEmpty(carName)) {
            throw new IllegalArgumentException(CAR_EMPTY_VALUE_MSG);
        }
        if (hasCarNameMoreThanFiveCharacter(carName)) {
            throw new IllegalArgumentException(TOO_LONG_NAME_MSG);
        }
        this.carName = carName;
    }

    private boolean carNameEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    private boolean hasCarNameMoreThanFiveCharacter(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(carName, name1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
