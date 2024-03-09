package racingcar;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름에 null이 들어옴");
        }
        final String trimmedName = name.trim();
        assertValidName(trimmedName);

        this.name = trimmedName;
    }

    private void assertValidName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }

    public String value() {
        return name;
    }
}
