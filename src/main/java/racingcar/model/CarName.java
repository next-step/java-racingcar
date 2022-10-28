package racingcar.model;

import java.util.Objects;
import racingcar.ExceptionMessageUtils;

public final class CarName {

    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    private CarName(final String value) {
        validateValue(value);
        this.value = value.trim();
    }

    private static void validateValue(final String value) {
        if (value == null) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name cannot be null"));
        }
        final String trimmedValue = value.trim();
        if (trimmedValue.isBlank()) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name cannot be blank"));
        }
        if (trimmedValue.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                ExceptionMessageUtils.createdExceptionMessage(
                    "Car name is too long"));
        }
    }

    public static CarName from(final String value) {
        return new CarName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
