package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int TEXT_GROUP_INDEX = 2;
    private static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }

        Matcher customDelimiterMatcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            text = customDelimiterMatcher.group(TEXT_GROUP_INDEX);

            return sum(split(text, customDelimiter));
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        return split(text, DEFAULT_DELIMITER);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sum(String[] text) {
        return Arrays.stream(text)
                .map(Positive::new)
                .mapToInt(Positive::getNumber)
                .sum();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
