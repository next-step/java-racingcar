package racingcar.domain;

import java.util.Objects;

public class Name {
    private final int LIMIT_OF_NAME = 5;

    private final String name;

    public Name(String name) {
        checkNameLength(name);

        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > LIMIT_OF_NAME) {
            throw new IllegalArgumentException("Name length must be below five");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Name carName = (Name) object;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
