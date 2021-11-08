package racinggame.utils;

import racinggame.exception.EmptyAndNullSourceException;
import racinggame.exception.InvalidInputException;
import racinggame.exception.ZeroStringException;

public class InputValidator {

    private static final String ZERO_STRING = "0";
    private static final String EMPTY_SOURCE = "";

    // error message
    public static final String ZERO_INPUT_MESSAGE = "입력값은 1이상으로 입력해주세요.";
    public static final String INVALID_SOURCE_MESSAGE = "공백은 입력할 수 없습니다.";
    public static final String INVALID_INPUT_MESSAGE = "회수를 입력해주세요.";


    private InputValidator() {
    }

    public static void validate(String input) {
        validateZero(input);
        validateNullAndEmptySource(input);
        validateString(input);
    }

    private static void validateZero(String input) {
        if (ZERO_STRING.equals(input)) {
            throw new ZeroStringException(ZERO_INPUT_MESSAGE);
        }
    }

    private static void validateNullAndEmptySource(String input) {
        if ((EMPTY_SOURCE.equals(input)) || (input == null)) {
            throw new EmptyAndNullSourceException(INVALID_SOURCE_MESSAGE);
        }
    }

    private static void validateString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_INPUT_MESSAGE);
        }
    }
}
