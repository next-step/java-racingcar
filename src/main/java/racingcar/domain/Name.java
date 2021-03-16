package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final String CHECK_NAME_NULL = "이름 값이 null인지 확인해주세요.";
    private static final String CHECK_NAME_EMPTY = "이름 값이 공백인지 확인해주세요.";
    private static final String CHECK_NAME_LENGTH = "이름이 5자를 초과했는지 확인해주세요.";
    private static final int NAME_LENGTH_BOUND = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        checkNull(name);
        checkEmpty(name);
        checkLength(name);
    }

    private void checkNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(CHECK_NAME_NULL);
        }
    }

    private void checkEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(CHECK_NAME_EMPTY);
        }
    }

    private void checkLength(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException(CHECK_NAME_LENGTH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
