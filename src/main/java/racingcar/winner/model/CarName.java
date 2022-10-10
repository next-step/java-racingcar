package racingcar.winner.model;

import java.util.Objects;

import racingcar.winner.exception.InvalidInputException;

public class CarName {
    private static final int NAME_MAX_LENGTH = 5;
    private String value;

    public CarName(final String value) {
        nameShouldNotBlank(value);
        validateNameLength(value);

        this.value = value;
    }

    private void nameShouldNotBlank(String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidInputException("자동차의 이름은 공백을 가질 수 없습니다");
        }
    }

    private void validateNameLength(String value) {
        if (value.length() > NAME_MAX_LENGTH) {
            throw new InvalidInputException("자동차의 이름은 5자를 초과할 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String getValue() {
        return value;
    }
}
