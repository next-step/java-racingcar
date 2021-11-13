package racinggame.utils;

import racinggame.exception.*;

public class InputValidator {

    private static final String ZERO_STRING = "0";
    private static final String EMPTY_SOURCE = "";

    private InputValidator() {
        throw new NotInstanceException();
    }

    public static void validateAttempts(String input) {
        validateZero(input);
        validateNullAndEmptySource(input);
        validateString(input);
    }

    public static void validateNullAndEmptySource(String input) {
        if ((EMPTY_SOURCE.equals(input)) || (input == null)) {
            throw new EmptyAndNullSourceException();
        }
    }

    private static void validateZero(String input) {
        if (ZERO_STRING.equals(input)) {
            throw new ZeroStringException();
        }
    }

    private static void validateString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException();
        }
    }
}
