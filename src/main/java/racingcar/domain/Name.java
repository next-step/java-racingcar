package racingcar.domain;

import java.util.Objects;

public class Name {
    private final static int VALID_LENGTH = 5;
    String name;

    public Name(String name) {
        this.name = name;
        validLength();
    }

    public Name(Name name) {
        this.name = name.name;
        validLength();
    }

    public Boolean validLength() {
        if (this.name.length() > VALID_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public String getName() {
        return this.name;
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
