package racingcar.domain.model;

import java.util.Objects;
import racingcar.domain.exception.NameNullPointerException;
import racingcar.domain.exception.NameOutOfRangeException;

public class Name {

    private static final int MINIMUM_SIZE = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        valid(name);
        return new Name(name);
    }

    public String getName() {
        return name;
    }

    private static void valid(String name) {
        validNullOrEmpty(name);
        validSize(name);
    }

    private static void validNullOrEmpty(String name) {
        if(name == null || name.isEmpty()) {
            throw new NameNullPointerException();
        }
    }

    private static void validSize(String name) {
        if(name.length() > MINIMUM_SIZE) {
            throw new NameOutOfRangeException(MINIMUM_SIZE);
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
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
