package step5.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateNameLength(name);
        validateValueExists(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateValueExists(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("빈값은 이름으로 쓸 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
