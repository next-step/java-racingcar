package racingCar.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 반드시 입력하세요.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 글자 수는 반드시 5글자 이하여야 합니다. : " + name);
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
