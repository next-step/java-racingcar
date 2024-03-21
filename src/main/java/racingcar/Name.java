package racingcar;

import java.util.Objects;

public final class Name {
    private final String name;

    public Name(String name) {
        if ((name == (null)) || (name.isEmpty()) || (name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5글자 이내여야 합니다.");
        }
        this.name = name;
    }

    public String get() {
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
