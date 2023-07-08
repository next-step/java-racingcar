package racingcar.domain;

import java.util.Objects;

public final class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NOT_VALID_NAME_LENGTH_MESSAGE = "이름은 정해진 길이를 넘을 수 없습니다.";

    private final String value;

    private Name(final String value) {
        validate(value);
        this.value = value;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    public String getValue() {
        return value;
    }

    private void validate(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NOT_VALID_NAME_LENGTH_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
