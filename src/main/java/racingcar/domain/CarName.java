package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_NO_VALUE_MESSAGE = "자동차의 이름의 값이 없습니다.";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름이 너무 깁니다. (" + CAR_NAME_MAX_LENGTH + "자 이하로)";

    private final String name;

    public CarName(final String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException(CAR_NAME_NO_VALUE_MESSAGE);
        }
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        this.name = name.trim();
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    String getName() {
        return name;
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
