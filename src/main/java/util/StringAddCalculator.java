package util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        int[] numbers = toIntArray(text);
        return sum(numbers);
    }

    private static int sum(int[] numbers) {
        return IntStream.of(numbers).sum();
    }

    private static int[] toIntArray(String text) {
        String[] tokens = splitByCustomOrDefaultDelimiter(text);
        return Arrays.stream(tokens)
                .mapToInt(StringAddCalculator::toInt)
                .toArray();
    }

    private static String[] splitByCustomOrDefaultDelimiter(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String source = matcher.group(2);
            return source.split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);

        assertPositive(number);

        return number;
    }

    private static void assertPositive(int value) {
        if(value < 0) {
            throw new IllegalArgumentException();
        }
    }
}
