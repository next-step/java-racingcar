package racingcar.domain;

import java.util.Objects;

public class Name {

    private final int NAME_MAX_LENGTH = 5;
    private final String ERROR_CHECK_LENGTH = "자동차 이름은 " + NAME_MAX_LENGTH + "자를 초과할 수 없다.";

    private final String name;

    public Name(String name) {
        this.name = name;
        checkName();
    }

    private void checkName() {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(ERROR_CHECK_LENGTH);
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
        return Objects.hash(NAME_MAX_LENGTH, ERROR_CHECK_LENGTH, name);
    }
}
