package step2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_REGEX = "(-\\d+).*";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final Pattern NEGATIVE_PATTERN = Pattern.compile(NEGATIVE_REGEX);

    private static Matcher getCustomMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    private static Matcher getNegativeMatcher(String input) {
        return NEGATIVE_PATTERN.matcher(input);
    }

    public static Boolean hasCustomDelimiter(String input) {
        return getCustomMatcher(input).matches();
    }

    public static String[] parseWithCustomDelimiterOrNull(String input) {
        Matcher customMatcher = getCustomMatcher(input);

        if (customMatcher.find()) {
            final String delimiter = customMatcher.group(1);
            return customMatcher.group(2).split(delimiter);
        }
        return null;
    }

    public static void hasNegativeNumber(String input) {
        Matcher negativeMatcher = getNegativeMatcher(input);

        if (negativeMatcher.matches()) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
