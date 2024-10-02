package stringadder.delimiter;

import stringadder.exception.StringAddIllegalArgumentException;

public abstract class DefaultNumberParser implements NumberParser {

    public static int parsePositiveInt(String text) {
        int number = Integer.parseInt(text);
        validatePositive(number);
        return number;
    }

    public static void validatePositive(int num) {
        if (num < 0) {
            throw StringAddIllegalArgumentException.INVALID_NEGATIVE_INPUT_NUMBER;
        }
    }
}
