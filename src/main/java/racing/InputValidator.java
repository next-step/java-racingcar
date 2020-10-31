package racing;

import static common.ErrorMessage.NOT_BLANK;
import static common.ErrorMessage.OUT_OF_RANGE;

public final class InputValidator {

    public static final String BLANK = " ";

    private InputValidator() {}

    public static void validate(final String input) {
        if (input == null || input.isEmpty() || input.equals(BLANK)) {
            throw new IllegalArgumentException(NOT_BLANK);
        }

        final int inputNumber = Integer.parseInt(input);
        if (inputNumber < 1 || inputNumber >= 20) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}
