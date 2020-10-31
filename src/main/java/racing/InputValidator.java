package racing;

import static common.ErrorMessage.NOT_BLANK;
import static common.ErrorMessage.OUT_OF_RANGE;

public final class InputValidator {

    private static final String BLANK = " ";

    private InputValidator() {}

    public static void validate(final String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(NOT_BLANK);
        }

        if (isOutOfRange(input)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty() || input.equals(BLANK);
    }

    public static boolean isOutOfRange(String input) {
        final int inputNumber = Integer.parseInt(input);
        return inputNumber < 1 || inputNumber >= 20;
    }
}
