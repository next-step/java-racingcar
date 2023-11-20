package racingcar.domain;

import java.util.Objects;

public class CarName {
    public static final String CAR_NAME_LENGTH_EXCEPTION = "자동차 이름은 1자에서 5자 사이여야 합니다. 이름이 공백이거나 비어있어도 안됩니다.";
    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (isOutOfLength(name)) {
            throw new IllegalStateException(CAR_NAME_LENGTH_EXCEPTION);
        }
    }

    private boolean isOutOfLength(String name) {
        return name.isEmpty() || name.isBlank() || name.length() > 5;
    }

    public String getName() {
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
