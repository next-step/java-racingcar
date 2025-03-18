package study;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_REGEX = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static int splitAndSum(final String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        return parseInput(text)
                .map(StringAddCalculator::sum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid input format"));
    }

    private static boolean isNullOrBlank(final String text) {
        return text == null || text.isBlank();
    }

    private static Optional<String[]> parseInput(final String text) {
        Matcher matcher = CUSTOM_DELIMITER_REGEX.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbersText = matcher.group(2);
            return Optional.of(numbersText.split(Pattern.quote(customDelimiter)));
        }

        return Optional.of(text.split(DEFAULT_DELIMITERS));
    }

    private static int sum(final String[] numbers) {
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(StringAddCalculator::parseNumber)
                .peek(StringAddCalculator::validatePositive)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static int parseNumber(final String number) {
        if (isNullOrBlank(number)) {
            throw new IllegalArgumentException("Empty value encountered while parsing numbers.");
        }
        return Integer.parseInt(number);
    }

    private static void validatePositive(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
        }
    }
}
