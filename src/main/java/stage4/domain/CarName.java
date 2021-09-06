package stage4.domain;

import stage4.exception.TooLongCarNameException;

import java.util.Objects;

public class CarName {
    private static final int STANDARD = 5;

    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public CarName(CarName carName) {
        this(carName.name);
    }

    private void validateEmpty(String name) {
        if (name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > STANDARD) {
            throw new TooLongCarNameException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;
        CarName carName = (CarName) o;
        return Objects.equals(getName(), carName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
