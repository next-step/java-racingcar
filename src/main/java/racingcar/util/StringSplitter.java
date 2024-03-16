package racingcar.util;

import static racingcar.config.RacingCarException.ARGUMENT_TEXT_BLANK;

public final class StringSplitter {

    private StringSplitter() {
    }

    public static String[] split(final String text, final String delimiter) {
        validateTextIsNotBlank(text);

        return text.split(delimiter);
    }

    private static void validateTextIsNotBlank(final String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException(ARGUMENT_TEXT_BLANK.message());
        }
    }
}
