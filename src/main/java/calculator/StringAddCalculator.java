package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);
    private static final int MATCHER_DELIMITER = 1;
    private static final int MATCHER_TEXT = 2;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(MATCHER_DELIMITER);
            return split(customDelimiter, m.group(MATCHER_TEXT));
        }

        return split(DEFAULT_DELIMITER, text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int split(String delimiter, String text) {
        String[] tokens = text.split(delimiter);
        return sum(toInts(tokens));
    }

    private static PositiveIntegers toInts(String[] values) {
        List<PositiveInteger> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(new PositiveInteger(value));
        }
        return new PositiveIntegers(numbers);
    }

    private static int sum(PositiveIntegers numbers) {
        return numbers.sum();
    }
}
