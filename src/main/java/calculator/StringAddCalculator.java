package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }

        Matcher customDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            String tokens = customDelimiterMatcher.group(2);

            return sum(split(tokens, customDelimiter));
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        return split(text, ",|:");
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sum(String[] text) {
        return Arrays.stream(text)
                .map(Positive::new)
                .map(Positive::getNumber)
                .reduce(Integer::sum)
                .orElse(DEFAULT_VALUE);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
