package racingcar.winner.utils;

public class StringUtils {

    private static final int MAX_NAME_LENGTH = 5;

    private StringUtils() {
    }

    public static String[] split(String input) {
        String[] values = input.split(",");
        validateInputValues(values);
        return values;
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
    public static String repeatCharacter(Character character, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(character);
        }
        return result.toString();
    }
}
