package step2;

public class Validation {

    public static final String VALID_NULL_EMPTY_CHECK_MSG = "입력값이 빈 값으로 옳바르지 않습니다.";

    public static void validNullAndEmpty(String text) {
        if (text == null || "".equals(text.trim()) ) {
            throw new IllegalArgumentException(VALID_NULL_EMPTY_CHECK_MSG);
        }
    }
}
