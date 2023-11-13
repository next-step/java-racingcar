package carRacing.domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = validateLength(name);
    }

    private String validateLength(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new StringIndexOutOfBoundsException();
        }
        return name;
    }

    public String name() {
        return this.name;
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
