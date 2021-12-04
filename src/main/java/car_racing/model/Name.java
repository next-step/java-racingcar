package car_racing.model;

import java.util.Objects;

public class Name {

    private static final String MESSAGE_NAME_LENGTH_EXCEPTION = "이름은 5자를 초과할 수 없습니다. ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            return;
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MESSAGE_NAME_LENGTH_EXCEPTION);
        }
    }

    public String getString() {
        return name;
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
