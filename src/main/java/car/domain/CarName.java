package car.domain;

import java.util.Objects;

public final class CarName {

    private final static int CAR_NAME_LENGTH_LOWER_BOUND = 5;

    private final String name;

    public CarName(final String name) {
        validateCarName(name);
        this.name = name.trim();
    }

    private void validateCarName(final String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LOWER_BOUND) {
            throw new IllegalArgumentException("자동자 이름의 길이가 하한선 보다 큽니다.");
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

    @Override
    public String toString() {
        return "CarName{" +
            "name='" + name + '\'' +
            '}';
    }
}
