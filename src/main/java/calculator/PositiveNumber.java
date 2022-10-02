package calculator;

import java.util.Objects;

public class PositiveNumber {

    public static final PositiveNumber ZERO = new PositiveNumber(0);

    private final int value;

    public PositiveNumber(int value) {
        if (value < 0) {
            throw new NumberFormatException("minus");
        }
        this.value = value;
    }

    public PositiveNumber plus(PositiveNumber positiveNumber) {
        Objects.requireNonNull(positiveNumber);
        return new PositiveNumber(value + positiveNumber.value);
    }

    public int intValue() {
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
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
