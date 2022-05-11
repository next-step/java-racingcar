package racingcar.utils;

public class StringUtils {

    private static final String DEFAULT_REGEX = ",";
    private static final int DEFAULT_TEXT_SIZE = 4;
    private static final String NULL_MESSAGE = "입력한 문자열은 null 값을 허용하지 않습니다";
    private static final String INSTANCE_ERROR_MESSAGE = "StringUtils 클래스를 인스턴스화 할수 없습니다";

    private StringUtils() {
        throw new AssertionError(INSTANCE_ERROR_MESSAGE);
    }

    public static boolean isBlank(String str) {
        nullCheck(str);

        return str.isBlank();
    }

    public static String[] split(String str) {
        nullCheck(str);

        return str.split(DEFAULT_REGEX);
    }

    public static boolean isMoreThanFiveLetters(String str) {
        nullCheck(str);

        return str.length() > DEFAULT_TEXT_SIZE;
    }

    private static void nullCheck(String str) {
        if (str == null) {
            throw new NullPointerException(NULL_MESSAGE);
        }
    }
}
