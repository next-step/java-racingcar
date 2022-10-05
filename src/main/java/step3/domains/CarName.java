package step3.domains;

import java.util.Objects;
import step3.exception.ExceedLengthException;
import step3.exception.NullOrEmptyException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullOrEmptyException();
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new ExceedLengthException(MAX_NAME_LENGTH);
        }

        this.name = name;
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
