package racinggame.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (value.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
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

    @Override
    public String toString() {
        return value;
    }

}
