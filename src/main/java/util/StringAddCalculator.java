package util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);
    private static final int ZERO = 0;
    private static final int DELIMITER_INDEX = 1;
    private static final int SOURCE_INDEX = 2;
    private static final String NO_NEGATIVE = "음수는 불가능합니다.";


    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return ZERO;
        }

        List<Integer> numbers = toIntegers(text);
        return sum(numbers);
    }

    private static List<Integer> toIntegers(String text) {
        String[] tokens = splitByCustomOrDefaultDelimiter(text);
        return Arrays.stream(tokens)
                .map(StringAddCalculator::toInt)
                .collect(toList());
    }

    private static String[] splitByCustomOrDefaultDelimiter(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_INDEX);
            String source = matcher.group(SOURCE_INDEX);
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
        if (value < ZERO) {
            throw new IllegalArgumentException(NO_NEGATIVE);
        }
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
