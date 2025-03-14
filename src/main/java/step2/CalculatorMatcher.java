package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorMatcher {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static Matcher getCustomMatcher(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input);
    }
}
