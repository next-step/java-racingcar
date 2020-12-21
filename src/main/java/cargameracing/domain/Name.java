package cargameracing.domain;

import java.util.Objects;

public class Name {
    static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name){
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("자동차 이름이 빈값이면 안됩니다.");
        }
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없음");
        }
        this.name = name;
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
