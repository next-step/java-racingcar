package calculator.number;

import calculator.exception.PositiveException;

import static calculator.exception.PositiveErrorMessage.NOT_ALLOWED_NEGATIVE;
import static calculator.exception.PositiveErrorMessage.NOT_ALLOWED_ZERO;

public class Positive {

    private final int value;

    public Positive(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new PositiveException(NOT_ALLOWED_NEGATIVE);
        }
        if (value == 0) {
            throw new PositiveException(NOT_ALLOWED_ZERO);
        }
    }

    public int value() {
        return value;
    }

}
