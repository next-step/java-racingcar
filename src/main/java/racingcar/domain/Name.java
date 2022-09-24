package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final String NOT_VALID_MESSAGE = "은(는) 유효한 이름이 아닙니다.";
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);

        this.value = value.strip();
    }

    public void validate(String name) {
        if (isNotValid(name)) {
            throw new IllegalArgumentException(name + NOT_VALID_MESSAGE);
        }
    }

    public boolean isNotValid(String name) {
        return isNullOrEmpty(name) || isOverLength(name);
    }

    private boolean isOverLength(String name) {
        return name.strip().length() > MAX_LENGTH;
    }

    private boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
