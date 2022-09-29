package racing.model;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return getName().equals(name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
