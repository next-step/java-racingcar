package racingcar.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(final String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(final String input) {
        if (Objects.isNull(input) || input.isEmpty() || input.length() > 5) {
            throw new RuntimeException("올바르지 않은 값입니다.");
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
