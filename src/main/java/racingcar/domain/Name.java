package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

import java.util.Objects;

public class Name {
    private final String name;
    private static final int BOUND = 5;

    public Name(String name) {
        this.name = name.trim();
        if(name.length() > BOUND) {
            throw new InvalidCarNameException(name);
        }
    }

    @Override
    public String toString(){
        return name;
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
