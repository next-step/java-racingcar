package racingcar.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }

        if (input.length() > 5) {
            throw new IllegalArgumentException("5자 이하의 이름만 입력 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof CarName)) {
            return false;
        }

        return this.name.equals(((CarName) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
