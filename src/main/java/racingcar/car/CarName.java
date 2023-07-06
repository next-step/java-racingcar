package racingcar.car;

import racingcar.exception.CarNameInputException;

public class CarName {
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.length() > 5) {
            throw new CarNameInputException();
        }
    }

    public String getValue() {
        return value;
    }
}
