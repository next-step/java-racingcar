package racingcar.domain;

import java.util.Objects;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("car must have name");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("car name can't be longer than 5 characters");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
