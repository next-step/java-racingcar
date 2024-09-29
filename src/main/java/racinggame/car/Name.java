package racinggame.car;

import racinggame.utils.StringUtils;
import racinggame.exception.CarException;

import static racinggame.exception.ErrorMessage.INVALID_CAR_NAME;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        final var isValidNameLength = StringUtils.isBlank(value) || value.length() > MAX_LENGTH;
        if (isValidNameLength) {
            throw new CarException(INVALID_CAR_NAME, MIN_LENGTH, MAX_LENGTH);
        }
    }

    private String value() {
        return this.value;
    }

}
