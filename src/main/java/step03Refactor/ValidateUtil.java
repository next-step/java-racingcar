package step03Refactor;

import static step03Refactor.Config.*;

public class ValidateUtil {

    public static void inputIsZero(int input1, int input2) {
        if (input1 <= 0 || input2 <= 0) {
            throw new IllegalArgumentException(ERROR_INPUT_ZERO);
        }
    }

    public static void inputIsZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_INPUT_ZERO);
        }
    }

    public static void inputStringSplitTextSize(String input) {
        String[] splitStrings = input.split(CAR_DELIMITER);
        for (String string : splitStrings) {
            inputStringIsNullOrMoreThanFiveLetters(string);
        }
    }

    public static void inputStringIsNullOrMoreThanFiveLetters(String input) {
        if (input.length() >= 5 || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_CAR_NAME_LENGTH);
        }
    }
}
