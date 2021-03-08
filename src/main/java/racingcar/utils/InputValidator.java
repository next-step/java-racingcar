package racingcar.utils;

public class InputValidator {

    private static final int ZERO = 0;

    private InputValidator() {
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 값인지 확인해주세요.");
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("비어있는 값인지 확인해주세요.");
        }
    }

    public static void validateLessThanZero(String input) {
        if (Integer.parseInt(input) <= ZERO) {
            throw new IllegalArgumentException("0이하의 값인지 확인해주세요.");
        }
    }
}
