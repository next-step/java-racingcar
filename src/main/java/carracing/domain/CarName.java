package carracing.domain;

import java.util.Objects;

public class CarName {

    public static final String NON_NULL = "CarName 입력값은 null 일 수 없습니다";
    public static final String NOT_EMPTY = "CarName 입력값은 비어있거나 공백 일 수 없습니다";
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        requireNonNull(name);
        requireNotEmpty(name);
    }

    private void requireNonNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }

    private void requireNotEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY);
        }
    }
}
