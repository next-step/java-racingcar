package calculator.domain;

public class Validator {

    private Validator() {};

    public static void validateUserInput(String[] userInput) {
        checkIsBlack(userInput);
        validateOddIndexIsNumber(userInput);
        validateEvenIndexIsOperator(userInput);
    }

    private static void checkIsBlack(String[] splitUserInput) {
        if (isBlank(splitUserInput)) {
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
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
        try {
            Long.parseLong(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] 입력 형식이 맞지 않습니다.");
        }
    }


    private static void validateEvenIndexIsOperator(String[] split) {
        for (int i = 1; i < split.length; i += 2) {
            validateIsOperator(split[i]);
        }
    }

    private static void validateIsOperator(String target) {
        if (!Expression.OPERATORS.contains(target)) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 맞지 않습니다.");
        }
    }
}
