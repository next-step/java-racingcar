package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final String NOT_VALID_MESSAGE = "은(는) 유효한 이름이 아닙니다.";
    public static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);

        this.name = name.strip();
    }

    private void validate(String name) {
        if (isNullOrEmpty(name) ||
            isOverLength(name)) {
            throw new IllegalArgumentException(name + NOT_VALID_MESSAGE);
        }
    }

    private static boolean isOverLength(String name) {
        return name.length() > MAX_LENGTH;
    }

    private static boolean isNullOrEmpty(String name) {
        return name == null || name.isEmpty();
    }

    public String name() {
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

        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
