package racinggame.utils;

import racinggame.exception.*;

public class InputValidator {

    private static final String ZERO_STRING = "0";
    private static final String EMPTY_SOURCE = "";
    private static final String NUMBER_CONFIRM_REGEX = "[+-]?\\d*(\\.\\d+)?";
    private static final int EMPTY_ARRAY = 0;
    private static final int NAME_LENGTH = 5;

    private InputValidator() {
        throw new NotInstanceException();
    }

    public static void validateCarNames(String input) {
        validateNullAndEmptySource(input);
        validateNameEmpty(extractNames(input));
        validateNumeric(input);
        validateNameLength(extractNames(input));
    }

    public static void validateAttempts(String input) {
        validateZero(input);
        validateNullAndEmptySource(input);
        validateString(input);
    }

    private static void validateNameEmpty(String[] names) {
        if (names.length == EMPTY_ARRAY) {
            throw new EmptyAndNullSourceException();
        }
    }

    private static void validateNumeric(String input) {
        if (input.matches(NUMBER_CONFIRM_REGEX)) {
            throw new NumericException();
        }
    }

    private static void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_LENGTH) {
                throw new OverNameLengthException();
            }
        }
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

    private static String[] extractNames(String input) {
        return input.split(",");
    }
}
