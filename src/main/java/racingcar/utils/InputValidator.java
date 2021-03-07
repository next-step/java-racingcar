package racingcar.utils;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
