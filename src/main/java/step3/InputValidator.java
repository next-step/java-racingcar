package step3;

public class InputValidator {

    private final static String NUMBER_PATTERN = "\\d*$";
    private final static String NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private final static String NULL_EXCEPTION_MESSAGE = "입력 값이 없습니다.";

    public static void isNumberForString(String input) {
        if (!input.matches(NUMBER_PATTERN)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static void isNullOrEmptyForString(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }

    public static void isNull(Long input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_EXCEPTION_MESSAGE);
        }
    }
}
