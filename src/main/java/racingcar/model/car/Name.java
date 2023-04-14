package racingcar.model.car;

import java.util.Objects;

public class Name implements Comparable<Name> {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty:" + name);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            String message = String.format("Car name cannot exceed %s character: %s", MAX_NAME_LENGTH, name);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Name o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Name) {
            Name name = (Name) o;
            return Objects.equals(this.name, name.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
