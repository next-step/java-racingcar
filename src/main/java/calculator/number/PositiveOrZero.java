package calculator.number;

import calculator.exception.PositiveOrZeroException;

import static calculator.exception.ErrorMessage.NOT_ALLOWED_NEGATIVE;

public class PositiveOrZero {

    private final int value;

    public static final PositiveOrZero ZERO = new PositiveOrZero(0);

    public PositiveOrZero(String value) {
        this(Integer.parseInt(value));
    }

    public PositiveOrZero(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new PositiveOrZeroException(NOT_ALLOWED_NEGATIVE);
        }
    }

    public PositiveOrZero add(PositiveOrZero addend) {
        return new PositiveOrZero(this.value + addend.value);
    }

    public int value() {
        return value;
    }

}
