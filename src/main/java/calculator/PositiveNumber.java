package calculator;

import calculator.exception.InvalidNumberFormatException;
import calculator.exception.NotPositiveNumberException;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(final String str) {
        if (!str.matches("-?\\d+")) {
            throw new InvalidNumberFormatException();
        }

        int number = Integer.parseInt(str);
        if (number < 0) {
            throw new NotPositiveNumberException();
        }
        this.value = number;
    }

    public int getValue() {
        return this.value;
    }
}
