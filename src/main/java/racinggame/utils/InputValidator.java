package racinggame.utils;

import racinggame.exception.EmptyAndNullSourceException;
import racinggame.exception.InvalidInputException;
import racinggame.exception.NotInstanceException;
import racinggame.exception.ZeroStringException;

public class InputValidator {

    private static final String ZERO_STRING = "0";
    private static final String EMPTY_SOURCE = "";

    private InputValidator() {
        throw new NotInstanceException();
    }

    public static void validate(String input) {
        validateZero(input);
        validateNullAndEmptySource(input);
        validateString(input);
    }

    private static void validateZero(String input) {
        if (ZERO_STRING.equals(input)) {
            throw new ZeroStringException();
        }
    }

    private static void validateNullAndEmptySource(String input) {
        if ((EMPTY_SOURCE.equals(input)) || (input == null)) {
            throw new EmptyAndNullSourceException();
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
