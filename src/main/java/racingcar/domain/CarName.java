package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String BLANK_VALUE_MESSAGE = "자동차 이름의 값을 입력해주세요.";
    private static final String INVALID_CAR_NAME_MESSAGE = "자동차 이름이 너무 깁니다. (" + CAR_NAME_MAX_LENGTH + "자 이하로)";

    private final String name;

    public CarName(String name) {
        if(name.isBlank()) {
            throw new IllegalArgumentException(BLANK_VALUE_MESSAGE);
        }
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
        this.name = name;
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
