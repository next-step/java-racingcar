package calculator;

import calculator.exception.InvalidNumberFormatException;
import calculator.exception.NotPositiveNumberException;
import java.util.Objects;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(final String str) {
        if (!str.matches("-?\\d+")) {
            throw new InvalidNumberFormatException();
        }
        int number = Integer.parseInt(str);
        validatePositive(number);
        this.value = number;
    }

    public PositiveNumber(final int number) {
        validatePositive(number);
        this.value = number;
    }

    public int getValue() {
        return this.value;
    }

    private static void validatePositive(int number) {
        if (number < 0) {
            throw new NotPositiveNumberException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber that = (PositiveNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
