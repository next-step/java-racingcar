package racingcar.domain;

import racingcar.exception.CarNameInputException;

public class CarName {

    public static final int MAX_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.length() > MAX_LENGTH) {
            throw new CarNameInputException();
        }
    }

    public String getValue() {
        return value;
    }
}
