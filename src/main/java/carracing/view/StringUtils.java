package carracing.view;

import java.util.Collections;

public final class StringUtils {

    private static final String INVALID_REPEAT_REQUEST_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 repeat 요청입니다. str: %s, count : %s";
    private static final String EMPTY_STRING = "";

    public static String repeat(String str, int count) {
        validateRepeatInput(str, count);
        return String.join(EMPTY_STRING, Collections.nCopies(count, str));
    }

    private static void validateRepeatInput(String str, int count) {
        if (str == null || str.isEmpty() || count < 0) {
            throw new IllegalArgumentException(String.format(INVALID_REPEAT_REQUEST_EXCEPTION_MESSAGE_FORMAT, str, count));
        }
    }

}
