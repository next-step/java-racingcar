package calc;

import java.util.regex.Pattern;

public final class Processor {

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s");

    private Processor() {}

    public static String replaceWhitespaceCharacters(String expression) {
        return WHITESPACE_PATTERN.matcher(expression).replaceAll("");
    }
}
