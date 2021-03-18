package step4.model;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be null or blank.");
        }
        if (name.length() > CarRacingConstant.LIMIT_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("The name must be no more than 5 characters long.");
        }

        this.name = name.trim();
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Name name1 = (Name) other;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
