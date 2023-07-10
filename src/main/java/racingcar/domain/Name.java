package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 공백일 수 없습니다.");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 " + MAX_LENGTH + "이하여야 합니다.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Name name = (Name) other;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
