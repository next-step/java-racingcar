package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.)\\n(.*)");

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input))  return 0;
        return new PositiveOrZeros(parse(input)).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] parse(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!hasCustomDelimiter(matcher)) {
            return splitWithDefaultDelimiter(input);
        }

        String customDelimiter = matcher.group(1);
        String numbersPart = matcher.group(2);

        return numbersPart.split(buildCombinedPattern(customDelimiter));
    }

    private static boolean hasCustomDelimiter(Matcher matcher) {
        return matcher.find();
    }

    private static String[] splitWithDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER_PATTERN);
    }

    private static String buildCombinedPattern(String customDelimiter) {
        return DEFAULT_DELIMITER_PATTERN + "|" + escapeDelimiter(customDelimiter);
    }

    private static String escapeDelimiter(String customDelimiter) {
        return Pattern.quote(customDelimiter);
    }
}
