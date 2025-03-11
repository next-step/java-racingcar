package vo;

import exception.NegativeNumberException;
import exception.NotNumberException;
import utils.NumberUtils;

public class PositiveInteger {
    private final int value;

    private PositiveInteger(String stringValue) {
        validateNotNumber(stringValue);
        int value = Integer.parseInt(stringValue);
        validateNegative(value);
        this.value = value;
    }

    private static void validateNegative(int value) {
        if (value < 0) {
            throw new NegativeNumberException();
        }
    }

    private static void validateNotNumber(String string) {
        if (!NumberUtils.isNumber(string)) {
            throw new NotNumberException();
        }
    }

    public static PositiveInteger of(String value) {
        return new PositiveInteger(value);
    }

    public int value() {
        return value;
    }
}
