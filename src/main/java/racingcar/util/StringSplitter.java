package racingcar.util;

public final class StringSplitter {

    private static final String BLANK_TEXT_MESSAGE = "빈문자열, 공백, 개행은 구분자를 이용해 자를 수 없습니다.";

    private StringSplitter() {
    }

    public static String[] split(final String text, final String delimiter) {
        validateTextIsNotBlank(text);

        return text.split(delimiter);
    }

    private static void validateTextIsNotBlank(final String text) {
        if (text.isBlank()) {
            throw new IllegalArgumentException(BLANK_TEXT_MESSAGE);
        }
    }
}
