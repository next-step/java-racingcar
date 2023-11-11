package racewinner.domain;

import java.util.Objects;

public class Name {
    private final static String EMPTY_NAME_MSG = "자동차 이름은 값이 존재해야 합니다.";
    private final static String LONG_NAME_MSG = "자동차 이름은 5글자를 초과할 수 없습니다.";
    private final static int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validationCheck(name);

        this.name = name;
    }

    private void validationCheck(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_MSG);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LONG_NAME_MSG);
        }
    }

    public String get() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
