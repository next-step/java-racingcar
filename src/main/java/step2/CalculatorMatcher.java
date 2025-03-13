package step2;

import java.util.regex.Pattern;

public class CalculatorMatcher {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String NEGATIVE_REGEX = "(-\\d+).*";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    private static final Pattern NEGATIVE_PATTERN = Pattern.compile(NEGATIVE_REGEX);

    public static java.util.regex.Matcher getCustomMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }

    public static java.util.regex.Matcher getNegativeMatcher(String input) {
        return NEGATIVE_PATTERN.matcher(input);
    }
}
