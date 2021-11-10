package step4.domain;

import java.util.Objects;

public class Name {

    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름의 길이는 1~5자 입니다.";

    private final String name;

    public Name(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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
}
