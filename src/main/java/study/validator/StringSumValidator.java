package study.validator;

public class StringSumValidator {

    public static boolean validatePositive(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
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
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }
}
