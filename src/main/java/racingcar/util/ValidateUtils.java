package racingcar.util;

public class ValidateUtils {
    private static final int MIN_NO = 1;
    private static final String EMPTY_MESSAGE = "값이 없습니다.";

    public static boolean validateMin(int no) {
        return no < MIN_NO;
    }

    public static void validateEmpty(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }
}
