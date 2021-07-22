package racingcar.vehicle;

import racingcar.common.ErrorMessage;

public class CarName {

    private final String name;

    public CarName(String name) {
        if (!nameValidation(name)) {
            throw new IllegalArgumentException(ErrorMessage.TOO_LONG_CAR_NAME_LENGTH);
        }

        this.name = name;
    }

    private boolean nameValidation(String name) {
        if (name.length() > 5) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }
}
