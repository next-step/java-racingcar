package racingCar.domain;

import java.util.Objects;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getCarNameLength() {
        return this.carName.length();
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
}
