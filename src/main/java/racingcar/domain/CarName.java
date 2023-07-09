package racingcar.domain;

import racingcar.exception.CarNameInputException;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private static final String CAR_NAME_MESSAGE = "자동차 이름의 길이가 " + MAX_LENGTH + "이하여야 합니다.";
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.length() > MAX_LENGTH) {
            throw new CarNameInputException(CAR_NAME_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
