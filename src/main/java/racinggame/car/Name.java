package racinggame.car;

import racinggame.utils.StringUtils;
import racinggame.exception.CarException;

import java.util.Objects;

import static racinggame.exception.ErrorMessage.INVALID_CAR_NAME;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        final var isValidNameLength = StringUtils.isBlank(value) || value.length() > MAX_LENGTH;
        if (isValidNameLength) {
            throw new CarException(INVALID_CAR_NAME, MIN_LENGTH, MAX_LENGTH);
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
