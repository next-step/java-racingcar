package racingcar;

import code.PromptMessage;

public class InputValidator {
    public static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            validateLength(carName);
        }
    }

    private static void validateLength(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(PromptMessage.INPUT_HAVE_TO_BE_NOT_BLANK.getMessage());
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(PromptMessage.CAR_NAME_IS_EQUAL_LOWER_THAN_5.getMessage());
        }
    }
}
