package step4.domain;

import java.util.Objects;

public class Name {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름의 길이는 1~5자 입니다.";

    private final String value;

    public Name(String value) {
        if (value.length() < 1 || value.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(value, name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
