package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitor {

    private static final String DEFAULT_SEPARATORS = ",:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*)\\\\n";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    public static boolean isValid(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        return true;
    }

    public static String[] split(String input) {
        return removeSeparatorPhrase(input).split(makeRegex(input));
    }

    private static String removeSeparatorPhrase(String text) {
        return text.replaceAll(CUSTOM_SEPARATOR_REGEX, "");
    }

    private static String makeRegex(String text) {
        return "[" + DEFAULT_SEPARATORS + findCustomSeparators(text) + "]";
    }

    private static String findCustomSeparators(String text) {
        String customSeparators = "";
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        while (matcher.find()) {
            String match = matcher.group(1);
            customSeparators += match;
        }
        return customSeparators;
    }

}
