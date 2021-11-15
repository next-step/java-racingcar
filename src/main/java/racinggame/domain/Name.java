package racinggame.domain;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String ERROR_CAR_NAME_MAX_LENGTH = "[ERROR] 자동차의 이름은 5글자 이하여야 합니다.";

    private final String name;

    public Name(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_MAX_LENGTH);
        }
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
}
