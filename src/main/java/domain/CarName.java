package domain;

import java.util.Objects;

public class CarName {
    public static final int MAX_LENGTH_NAME = 5;
    public static final int EMPTY_LENGTH_NAME = 0;
    private final String name;

    public CarName(String name) {
        if (name.trim().length() > MAX_LENGTH_NAME) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
        if (name.trim().length() == EMPTY_LENGTH_NAME) {
            throw new IllegalArgumentException("자동차 이름은 빈값이 될 수 없다.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(this.name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
