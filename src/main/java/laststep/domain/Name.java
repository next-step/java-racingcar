package laststep.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없어요");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없어요");
        }
    }

    public String print() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
