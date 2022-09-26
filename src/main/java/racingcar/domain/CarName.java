package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    String name;

    public CarName(String name) {
        this.name = name.trim();
        validateCarName(this.name);
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백이 포함될 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CarName) {
            CarName o = (CarName) obj;
            return this.name.equals(o.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
