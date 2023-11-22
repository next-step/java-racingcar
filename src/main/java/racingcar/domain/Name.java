package racingcar.domain;

import java.util.Objects;

public class Name {

    public static final int MIN_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        name = name.trim();
        if (isNameGreaterThan(name)) {
            throw new StringIndexOutOfBoundsException();
        }
        this.name = name;
    }

    public String value() {
        return name;
    }

    private boolean isNameGreaterThan(String name) {
        return name.length() > MIN_NAME_LENGTH;
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

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }
}
