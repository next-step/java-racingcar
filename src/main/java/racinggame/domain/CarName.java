package racinggame.model;

import java.util.Objects;

public final class CarName {

    private static final int LIMITED_NAME_LENGTH = 5;
    String carName;

    CarName(String carName) {
        if (carName.length() > LIMITED_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return carName;
    }
}
