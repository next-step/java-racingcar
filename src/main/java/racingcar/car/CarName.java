package racingcar.car;

import racingcar.exception.CarNameInputException;

public class CarName {
    private final String value;

    public CarName(String value) {
        if (validate(value)) {
            throw new CarNameInputException();
        }
        this.value = value;
    }

    private boolean validate(String value) {
        return value == null || value.length() > 5;
    }

    public String getValue() {
        return value;
    }
}
