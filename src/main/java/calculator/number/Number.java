package calculator.number;

import calculator.exception.NumberException;

import java.util.Objects;

import static calculator.exception.ErrorMessage.NON_NUMERICAL;
import static calculator.exception.ErrorMessage.NOT_ALLOWED_NEGATIVE;

public class Number {

    private final int value;

    public static final Number ZERO = new Number(0);

    private static final int MINIMUM_VALUE = 0;

    public Number(String value) {
        try {
            final var intValue = Integer.parseInt(value);
            validate(intValue);
            this.value = intValue;
        } catch (NumberFormatException exception) {
            throw new NumberException(NON_NUMERICAL);
        }
    }

    public Number(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_VALUE) {
            throw new NumberException(NOT_ALLOWED_NEGATIVE);
        }
    }

    public Number add(Number addend) {
        return new Number(this.value + addend.value);
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

}
