package racingcar.domain.vehicle;

import java.util.Objects;
import racingcar.common.exception.InvalidCarNameException;

public class Name {

    private static final int MIN_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void nameValidation(String name) {
        if (name.length() > MIN_NAME_LENGTH) {
            throw new InvalidCarNameException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
