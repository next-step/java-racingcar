package racingcar.domain;

import racingcar.exception.InvalidCarNameException;

public class Name {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        isValid(name);
        this.name = name;
    }

    private void isValid(String name) {
        if (name.trim().length() > CAR_NAME_MAX_LENGTH) {
            throw new InvalidCarNameException();
        }
    }

    public String getName() {
        return name;
    }
}
