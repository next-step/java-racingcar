package racingcar.backend.domain;

import java.util.Objects;

public class CarName {

    private static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public CarName(final String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String gatValue() {
        return this.name;
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
}
