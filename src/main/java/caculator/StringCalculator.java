package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\n(.*)");

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        return new PositiveOrZeros(split(input)).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            return input.split(DEFAULT_DELIMITER_PATTERN);
        }

        String customDelimiterPattern = buildCustomDelimiterPattern(matcher);
        String numbersPart = extractNumbersPart(matcher);
        return numbersPart.split(customDelimiterPattern);
    }

    private static String buildCustomDelimiterPattern(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return addCustomDelimiter(customDelimiter);
    }
    
    private static String addCustomDelimiter(String customDelimiter) {
        return DEFAULT_DELIMITER_PATTERN + "|" + customDelimiter;
    }

    private static String extractNumbersPart(Matcher matcher) {
        return matcher.group(2);
    }
}
