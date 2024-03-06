package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String CUSTOM_DELIMITER_GROUP = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_GROUP);
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int TOKENS_GROUP_INDEX = 2;
    private static final int DEFAULT_SUM = 0;

    public static int splitAndSum(final String line) {
        if (line == null || line.isBlank()) {
            return DEFAULT_SUM;
        }

        final String[] tokens = split(line);
        return calculateSum(tokens);
    }

    private static String[] split(final String line) {
        final Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(line);
        if (m.find()) {
            final String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP_INDEX);
            return m.group(TOKENS_GROUP_INDEX).split(customDelimiter);
        }
        return line.split(DEFAULT_DELIMITERS);
    }

    private static int calculateSum(final String[] tokens) {
        int sum = DEFAULT_SUM;
        for (final String value : tokens) {
            final int number = convertStringToInt(value);
            validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static int convertStringToInt(final String value) {
        try {
            return Integer.parseInt(value);
        } catch (final NumberFormatException e) {
            throw new RuntimeException("숫자를 입력하세요.");
        }
    }

    private static void validatePositive(final int value) {
        if (value < DEFAULT_SUM) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }
}
