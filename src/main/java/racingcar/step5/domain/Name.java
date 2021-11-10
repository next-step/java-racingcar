package racingcar.step5.domain;

import java.util.Objects;

import static racingcar.step5.message.ErrorMessage.*;

public class Name {

    private final String name;

    public Name(String name) {
        checkCarNaming(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkCarNaming(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException(NO_EMPTY_MESSAGE);

        if (name.length() > 5) {
            throw new IllegalArgumentException(NO_OVER_FIVE_MESSAGE);
        }
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
        return name;
    }

}
