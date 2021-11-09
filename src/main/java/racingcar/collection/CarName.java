package racingcar.collection;

import racingcar.exception.NotEmptyCarNameException;
import racingcar.exception.TooLongCarNameException;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateEmptyCarName(name);
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateEmptyCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NotEmptyCarNameException();
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new TooLongCarNameException();
        }
    }

    public String toString() {
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
