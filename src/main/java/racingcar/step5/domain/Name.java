package racingcar.step5.domain;

import java.util.Objects;

public class Name {

    private String name;

    public Name(String name) {
        checkCarNaming(name);
        this.name = name;
    }

    private void checkCarNaming(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("빈 값일 수 없습니다.");

        if (name.length() > 5) {
            throw new IllegalArgumentException("5자를 초과 할 수 없습니다");
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
