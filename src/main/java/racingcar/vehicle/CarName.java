package racingcar.vehicle;

import racingcar.common.exception.InvalidCarNameException;

public class CarName {

    private static final int MIN_NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if (!nameValidation(name)) {
            throw new InvalidCarNameException();
        }

        this.name = name;
    }

    private boolean nameValidation(String name) {
        if (name.length() > MIN_NAME_LENGTH) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }
}
