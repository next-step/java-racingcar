package racingcar.domain;

import java.util.Objects;

import static racingcar.exception.Message.MAX_LENGTH_ERROR;
import static racingcar.exception.Message.NULL_OR_EMPTY_ERROR;

public class Name {

    private static final int LIMIT = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR);
        }
        if (name.length() > LIMIT) {
            throw new IllegalArgumentException(MAX_LENGTH_ERROR);
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
