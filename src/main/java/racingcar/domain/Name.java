package racingcar.domain;

import java.util.Objects;

public class Name {

    private final String value;

    private Name(final String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
        this.value = value;
    }

    public static Name from(final String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return value;
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
