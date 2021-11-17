package study.racing.domain;

import java.util.Objects;

import study.racing.exception.InvalidCarNameException;

public class Name {

    public static final String INVALID_NAME_MESSAGE = "car name length must not greater than ";
    public static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new InvalidCarNameException(INVALID_NAME_MESSAGE + NAME_LENGTH_LIMIT);
        }
        this.name = name;
    }

    @Override
    public String toString() {
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
