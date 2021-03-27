package step03Refactor;

import static step03Refactor.CarFactory.CAR_DELIMITER;

public class ValidateUtil {
    private static final String ERROR_INPUT_ZERO = "입력값은 0 이상이어야 합니다.";
    private static final String ERROR_INPUT_CAR_NAME_LENGTH = "차 이름은 0글자 이상 5글자 이하로 입력해주세요.";

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
