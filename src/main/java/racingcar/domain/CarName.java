package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int NAME_MAX_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        validateNotBlank(value);
        validateMaxLength(value);
        this.value = value;
    }

    private void validateNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("length of name should not be blank");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("length of name should be less than %d", NAME_MAX_LENGTH));
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(value, carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
