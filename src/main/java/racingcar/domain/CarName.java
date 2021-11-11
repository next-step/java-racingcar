package racingcar.domain;

import racingcar.exception.CarNameException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private final String carName;

    private CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null) {
            throw new CarNameException();
        }
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new CarNameException(carName);
        }
    }

    public static CarName from(String name) {
        return new CarName(name);
    }
}
