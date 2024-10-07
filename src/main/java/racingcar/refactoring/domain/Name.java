package racingcar.refactoring.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
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
