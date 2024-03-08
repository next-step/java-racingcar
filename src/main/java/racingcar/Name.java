package racingcar;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        Objects.requireNonNull(name);
        this.name = name.trim();

        assertValidName(this.name);
    }

    private void assertValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
