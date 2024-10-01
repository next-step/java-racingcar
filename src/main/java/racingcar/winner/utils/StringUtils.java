package racingcar.winner.utils;

public class StringUtils {

    public static final int MAX_NAME_LENGTH = 5;

    public static String[] split(String input) {
        String[] splited = input.split(",");
        validateInputValues(splited);
        return splited;
    }

    private static void validateInputValues(String[] values) {
        for (String value : values) {
            checkNameLength(value);
        }
    }

    private static void checkNameLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}