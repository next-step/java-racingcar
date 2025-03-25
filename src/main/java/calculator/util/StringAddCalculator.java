package calculator.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public int splitAndSum(String text) {
        if (isNullOrBlank(text)) return 0;

        return sum(convertToNumbers(splitByDelimiter(text)));
    }

    private boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private String[] splitByDelimiter(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String textWithCustomDelimiter = matcher.group(2);
            return textWithCustomDelimiter.split(combineDefaultDelimiterWith(customDelimiter));
        }
        return text.split(DEFAULT_DELIMITER_REGEX);
    }

    private String combineDefaultDelimiterWith(String customDelimiter) {
        return String.format("%s|%s", DEFAULT_DELIMITER_REGEX, Pattern.quote(customDelimiter));
    }

    private int[] convertToNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .filter(this::validatePositiveOrZero)
                .toArray();
    }

    private boolean validatePositiveOrZero(int number) {
        if (number < 0) throw new NumberFormatException();
        return true;
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
