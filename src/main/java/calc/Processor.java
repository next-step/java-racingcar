package calc;

import java.util.regex.Pattern;

public final class Processor {

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    private Processor() {}

    public static String replaceWhitespaceCharacters(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new IllegalArgumentException("expression must not be null");
        }

        return WHITESPACE_PATTERN.matcher(expression).replaceAll("");
    }
}
