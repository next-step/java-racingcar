package racingcar.domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validation(name);
        this.name = name;
    }

    private void validation(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(" 자동차 이름은 5자를 초과할 수 없습니다. - " + name);
        }
    }

    public String value() {
        return name;
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
