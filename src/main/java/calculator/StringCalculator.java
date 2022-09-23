package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        Matcher matcher = createMatcher(text);
        if (matcher.find()) {
            return sum(new PositiveNumbers(splitCustomizedText(matcher)));
        }
        return sum(new PositiveNumbers(splitDefaultText(text)));
    }

    private static int sum(PositiveNumbers positive) {
        return positive.sum();
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static Matcher createMatcher(String text) {
        return CUSTOM_SEPARATOR_PATTERN.matcher(text);
    }

    private static String[] splitDefaultText(String text) {
        return split(text, DEFAULT_SEPARATOR);
    }

    private static String[] splitCustomizedText(Matcher matcher) {
        return split(matcher.group(2), matcher.group(1));
    }

    private static String[] split(String text, String separator) {
        return text.split(separator);
    }
}
