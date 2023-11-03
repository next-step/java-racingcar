package study.validator;

public class StringSumValidator {

    private static final int STANDARD = 0;
    private static final String NEGATIVE_NUMBER_MESSAGE = "음수는 입력할 수 없습니다.";
    private static final String NOT_NUMBER_MESSAGE = "숫자가 아닌 값이 입력되었습니다.";

    public static boolean validatePositive(int number) {

        if (number < STANDARD) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE);
        }
        return true;
    }

    public static boolean validateBlank(String data) {

        if (data == null || data.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public static int validateNumber(String numberStr) {

        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
