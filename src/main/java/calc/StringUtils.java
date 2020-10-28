package calc;

import java.util.regex.Pattern;

public class StringUtils {

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    private StringUtils() {
    }

    public static boolean isBlank(String expression) {
        return expression == null || expression.isEmpty();
    }

    public static String replaceWhitespaceCharacters(String expression) {
        if (isBlank(expression)) {
            throw new IllegalArgumentException("expression must not be null");
        }

        return WHITESPACE_PATTERN.matcher(expression).replaceAll("");
    }
}
