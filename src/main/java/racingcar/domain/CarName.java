package racingcar.domain;

import racingcar.exception.CarNameException;

import java.util.Objects;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new CarNameException();
        }
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new CarNameException(carName);
        }
    }

    public static CarName from(String name) {
        return new CarName(name);
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
