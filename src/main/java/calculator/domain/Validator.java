package calculator.domain;

import java.util.InputMismatchException;

public class Validator {
    protected static final String OPERATORS = "+-*/";

    private Validator() {
    }

    public static void validateUserInput(String[] userInput) {
        checkIsBlack(userInput);
        validateOddIndexIsNumber(userInput);
        validateEvenIndexIsOperator(userInput);
    }

    private static void checkIsBlack(String[] splitUserInput) {
        if (isBlank(splitUserInput)) {
            throw new IllegalArgumentException("[ERROR] 식을 입력해 주세요.");
        }
    }

    private static boolean isBlank(String[] splitUserInput) {
        return splitUserInput.length == 0;
    }

    private static void validateOddIndexIsNumber(String[] split) {
        for (int i = 0; i < split.length; i += 2) {
            validateIsNumber(split[i]);
        }
    }

    private static void validateIsNumber(String target) {
            Long.parseLong(target);
    }

    private static void validateEvenIndexIsOperator(String[] split) {
        for (int i = 1; i < split.length; i += 2) {
            validateIsOperator(split[i]);
        }
    }

    private static void validateIsOperator(String target) {
        if (!OPERATORS.contains(target)) {
            throw new InputMismatchException("[ERROR] 해당 자리에는 연산자가 위치해야 합니다.(v op v op v ..)");
        }
    }
}
