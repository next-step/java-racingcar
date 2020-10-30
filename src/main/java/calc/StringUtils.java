package calc;

import java.util.regex.Pattern;

import static common.ErrorMessage.NOT_NULL;

public class StringUtils {

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static boolean isBlank(String expression) {
        return expression == null || expression.isEmpty();
    }

    public static String replaceWhitespaceCharacters(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException(NOT_NULL);
        }

        return WHITESPACE_PATTERN.matcher(expression).replaceAll(EMPTY);
    }
}
