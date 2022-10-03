package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getValue() {
        return name;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new RuntimeException("이름은 " + NAME_LENGTH + "를 초과할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name)o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
