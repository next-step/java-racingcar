package study.racingcar.car;

import java.util.Objects;

public class CarName {

    private static final int LENGTH_LIMIT = 5;

    private String value;

    public CarName(String value) {
        this.value = value;

        throwIfLengthLimitOver();
        throwIfNameIsBlank();
    }

    public String getValue() {
        return value;
    }

    private void throwIfLengthLimitOver() {
        if (value.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void throwIfNameIsBlank() {
        if (Objects.isNull(value) || value.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

}
