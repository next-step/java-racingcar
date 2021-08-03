package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validCarNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validCarNameLength(String carsName) {
        if (carsName.length() > MAX_NAME_LENGTH) {
            try {
                throw new InvalidCarNameException();
            } catch (InvalidCarNameException e) {
                e.printStackTrace();
            }
        }
    }
}
