package racingcar.domain;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        assertNameNotNull(name);

        name = name.trim();
        assertValidNameLength(name);
        return name;
    }

    private static void assertValidNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이어야 합니다.");
        }
    }

    private static void assertNameNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
    }

    public String getName() {
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

    @Override
    public String toString() {
        return name;
    }
}
