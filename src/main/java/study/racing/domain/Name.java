package study.racing.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(String value) {
        if (!nameValid()) {
            throw new IllegalArgumentException("이름은 1글자 이상, 5자 이하만 가능합니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private boolean nameValid() {

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
