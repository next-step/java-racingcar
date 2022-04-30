package racing.domain;

import racing.domain.exception.BlankNameException;
import racing.domain.exception.MaxNameLengthException;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new BlankNameException();
        }
        if (name.length() > 5) {
            throw new MaxNameLengthException();
        }
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

    @Override
    public String toString() {
        return this.name;
    }
}
