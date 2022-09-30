package racingcar.domain;

import java.util.Objects;

public class RacingCarName {

    private final int MAX_LENGTH_NAME = 5;

    private final String value;

    public RacingCarName(String value) {
        validateName(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateName(String name) {
        validateNameIsEmpty(name);
        validateNameLongerThenFive(name);
    }

    private void validateNameLongerThenFive(String name) {
        if (name.length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다. | 입력된 name: " + name);
        }
    }

    private void validateNameIsEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 빈 문자열로 설정할 수 없습니다.  | 입력된 name: " + name);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingCarName)) {
            return false;
        }

        RacingCarName that = (RacingCarName) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
