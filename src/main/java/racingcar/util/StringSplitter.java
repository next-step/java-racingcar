package racingcar.util;

public final class StringSplitter {

    private static final String BLANK_TEXT_MESSAGE = "공백 문자는 구분자를 이용해 자를 수 없습니다.";
    private static final String DELIMITER = ",";

    private StringSplitter() {
    }

    public static String[] split(final String text) {
        validateTextIsNotBlank(text);

        return text.split(DELIMITER);
    }

    private static void validateTextIsNotBlank(final String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException(BLANK_TEXT_MESSAGE);
        }
    }
}
