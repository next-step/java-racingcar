package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_LENGTH = 5;

    private String name;

    public Name(String name) {
        validateNullAndEmpty(name);
        validateSize(name);
        this.name = name;
    }

    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("차 이름은 null이거나 공백일 수 없습니다.");
        }
    }

    private void validateSize(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
