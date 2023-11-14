package study.racing.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(String value) {
        if (!nameValid(value)) {
            throw new IllegalArgumentException("이름의 길이를 벗어났습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean nameValid(String value) {

        return !value.isEmpty() && !value.isBlank() && value.length() <= MAX_NAME_LENGTH;
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
