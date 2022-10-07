package racing.domain;

import java.util.Objects;

public class Name {

    private static final String LENGTH_ERROR_TEXT = "이름은 5자를 초과할 수 없습니다.";
    private static final int NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        this.name = validateName(name);
    }

    public String getName() {
        return name;
    }

    private String validateName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_TEXT);
        }
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
