package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_LIMIT_LENGTH = 5;
    private static final String NAME_VALIDATION_MESSAGE = "[ERROR] 이름은 5 글자 이하입니다.";

    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(NAME_VALIDATION_MESSAGE);
        }
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
