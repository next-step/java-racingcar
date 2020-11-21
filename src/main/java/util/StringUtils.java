package util;

import java.util.regex.Pattern;

import static common.ErrorMessage.NOT_NULL;

public class StringUtils {

    public static final String BRACKETS_PATTERN = "[\\[\\]]";

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    public static final String EMPTY = "";

    public static final String NULL_CHARACTER = "\0";

    private StringUtils() {}

    public static boolean isBlank(String expression) {
        return expression == null || expression.isEmpty();
    }

    public static String replaceWhitespaceCharacters(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException(NOT_NULL);
        }

        return WHITESPACE_PATTERN.matcher(expression).replaceAll(EMPTY);
    }

    public static String removeBrackets(String input) {
        return input.replaceAll(BRACKETS_PATTERN, EMPTY);
    }

    public static String repeat(String input, int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, input);
    }
}
