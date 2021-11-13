package racingcar.domain;

import racingcar.exception.CarNameException;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private final String carName;

    private Name(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new CarNameException();
        }
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new CarNameException(carName);
        }
    }

    public static Name from(String name) {
        return new Name(name);
    }

    public String getName() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(carName, name1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
