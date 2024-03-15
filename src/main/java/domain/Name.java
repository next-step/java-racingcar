package domain;

import java.util.Objects;

public class Name {

    private static final String DEFAULT_NAME = "noop";

    private final String value;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.value = name;
    }

    public static Name createDefaultInstance() {
        return new Name(DEFAULT_NAME);
    }

    public String value() {
        return this.value;
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
