package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;

    public CarName(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
        }
    }

    private void validateBlank(String name) {
        if (name == null) {
            throw new NullPointerException("자동차 이름에 null이 올 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    public String getCarName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
