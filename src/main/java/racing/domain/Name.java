package racing.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Name(String value) {
        checkNameIsPossible(value);
        this.value = value;
    }

    private void checkNameIsPossible(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(name + " is over " + MAX_NAME_LENGTH + " letters");
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
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
