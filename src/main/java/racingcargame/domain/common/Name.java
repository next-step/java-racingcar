package racingcargame.domain.common;

import java.util.Objects;
import racingcargame.domain.common.exception.InvalidNameException;

public class Name {

    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public Name(String name) {
        nameValidation(name);
        this.name = name;
    }

    private void nameValidation(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new InvalidNameException();
        }
    }

    public String getValue() {
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
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
