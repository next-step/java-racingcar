package racinggame.domain.value;

import racinggame.exception.OverNameLengthException;

import java.util.Objects;

public class Name {
    private static final int VALID_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        validateLength(name);
        return new Name(name);
    }

    public String value() {
        return name;
    }

    private static void validateLength(String name) {
        if (name.length() > VALID_NAME_LENGTH) {
            throw new OverNameLengthException();
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
