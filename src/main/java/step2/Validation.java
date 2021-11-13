package step2;

public class Validation {

    public static final String VALID_NULL_EMPTY_CHECK_MSG = "입력값이 빈 값으로 옳바르지 않습니다.";
    public static final String VALID_ARITHMETHIC_INPUT_SIZE = "입력값과 연산자의 개수가 옳바르지 않습니다.";
    private static final String STRING_EMPTY_VALUE = "";

    public static void validNullAndEmpty(String text) {
        if (text == null || STRING_EMPTY_VALUE.equals(text.trim()) ) {
            throw new IllegalArgumentException(VALID_NULL_EMPTY_CHECK_MSG);
        }
    }
}
