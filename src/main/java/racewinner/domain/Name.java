package racewinner.domain;

import java.util.Objects;

public class Name {
    private final String name;
    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        this.name = name;
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
