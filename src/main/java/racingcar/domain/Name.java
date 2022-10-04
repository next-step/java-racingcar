package racingcar.domain;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름이 유효하지 않습니다.");
        }
        return assertValidNameLength(name.trim());
    }

    private static String assertValidNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이어야 합니다.");
        }
        return name;
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

}
