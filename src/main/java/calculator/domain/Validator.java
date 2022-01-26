package calculator.domain;

import static calculator.domain.Constants.*;

public class Validator {

    private Validator() {};

    public static void validateUserInput(String[] userInput) {
        checkIsBlank(userInput);
        validateOddIndexIsNumber(userInput);
        validateEvenIndexIsOperator(userInput);
    }

    private static void checkIsBlank(String[] splitUserInput) {
        if (isBlank(splitUserInput)) {
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
        }
    }

    private static boolean isBlank(String[] splitUserInput) {
        return splitUserInput.length == 0;
    }

    private static void validateOddIndexIsNumber(String[] split) {
        for (int i = 0; i < split.length; i += 2) {
            try {
                Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
            }
        }
    }

    private static void validateEvenIndexIsOperator(String[] split) {
        for (int i = 1; i < split.length; i += 2) {
            validateIsOperator(split[i]);
        }
    }

    private static void validateIsOperator(String target) {
        if (!OPERATORS.contains(target)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
        }
    }
}
