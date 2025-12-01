package domain;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if (!isNameValid(name)) {
            throw new RuntimeException(String.format("자동차 이름은 %d를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
        this.name = name;
    }

    private boolean isNameValid(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
