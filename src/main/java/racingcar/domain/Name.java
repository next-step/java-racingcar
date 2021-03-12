package racingcar.domain;

import java.util.Objects;

public class Name {
    private final String name;
    private final static int MAX_CAR_NAME = 5;

    public Name(String initialName) {
        verifyName(initialName);
        this.name = initialName;
    }

    public String getName() {
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

    private void verifyName(String name) {
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("carName must be less then or equal to 5");
        }
    }
}
