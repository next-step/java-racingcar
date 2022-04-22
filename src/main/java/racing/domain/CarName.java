package racing.domain;

import java.util.Objects;

public class CarName {
    private static final String NAME_MAX_LENGTH_ERROR_MESSAGE = "이름은 5를 초과할 수 없습니다.";
    private static final String NAME_BLANK_ERROR_MESSAGE = "이름을 공백일 수 없습니다.";

    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
