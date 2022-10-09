package racingcar.winner.model;

import java.util.Objects;

import racingcar.winner.exception.InvalidInputException;

public class CarName {
    private String value;

    public CarName(final String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidInputException("자동차의 이름은 공백을 가질 수 없습니다");
        }

        if (value.length() > 5) {
            throw new InvalidInputException("자동차의 이름은 5자를 초과할 수 없습니다");
        }

        this.value = value;
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
