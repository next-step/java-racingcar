package domain;

import java.util.Objects;

public class CarName {

    private final String name;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    public CarName(String name) {
        if (name == null || name.isBlank()) {
            throw new RuntimeException("입력받은 자동차 이름이 없습니다.");
        }
        if (CAR_NAME_MAX_LENGTH < name.length()) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
