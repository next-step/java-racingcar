package racing.domain;

import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    public static final int ZERO = 0;
    private final String name;

    public Name(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name is empty.");
        }
        this.name = substringMaxLength(name.trim());
    }

    private String substringMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            return name.substring(ZERO, MAX_LENGTH);
        }
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
