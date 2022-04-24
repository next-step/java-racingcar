package racingcar.domain.input;

import racingcar.domain.exception.MaximumCarNameException;
import racingcar.domain.exception.RequiredCarNameException;

import java.util.Objects;

public class CarName {

    private static final int MAX_LENGTH_CAR_NAME = 5;
    private String carName;

    public CarName(String carName) {
        if (isNullOrBlank(carName)) {
            throw new RequiredCarNameException();
        }
        if (isOverMaxLength(carName)) {
            throw new MaximumCarNameException();
        }
        this.carName = carName;
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > MAX_LENGTH_CAR_NAME;
    }

    private boolean isNullOrBlank(String carName) {
        return carName == null || carName.isBlank();
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
        return this.carName;
    }
}
