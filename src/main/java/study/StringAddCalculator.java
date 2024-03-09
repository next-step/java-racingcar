package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String COMMA_DELIMITER = ",";
    private static final String COLON_DELIMITER = ":";
    private static final String COMMA_OR_COLON_DELIMITER = String.format("%s|%s", COMMA_DELIMITER, COLON_DELIMITER);
    private static final int DEFAULT_VALUE_FOR_EMPTY_INPUT = 0;
    private static final String MESSAGE_INVALID_NUMBER_FORMAT = "올바른 숫자 입력값이 아닙니다";
    private static final String MESSAGE_NEGATIVE_NOT_ALLOWED = "음수는 허용되지 않습니다";
    private static final String CUSTOM_DELIMITER_PREFIX = "/";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(?<delimiter>.)\n(?<input>.*)");
    private static final String CUSTOM_DELIMITER_CHARACTER_GROUP_NAME = "delimiter";
    private static final String CUSTOM_DELIMITER_INPUT_GROUP_NAME = "input";
    private static final String MESSAGE_INVALID_CUSTOM_DELIMITER_FORMAT = "커스텀 구분자 입력 양식을 확인해주세요";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String input) {
        if (isNullOrEmpty(input)) {
            return DEFAULT_VALUE_FOR_EMPTY_INPUT;
        }

        final String[] splitInput = splitByDelimiter(input);

        return Arrays.stream(splitInput)
                .mapToInt(StringAddCalculator::parsePositiveSingleNumber)
                .sum();
    }

    private static String[] splitByDelimiter(final String input) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            final String customDelimiter = String.format("\\%s", matcher.group(CUSTOM_DELIMITER_CHARACTER_GROUP_NAME));
            final String inputToSplit = matcher.group(CUSTOM_DELIMITER_INPUT_GROUP_NAME);
            return inputToSplit.split(customDelimiter);
        }

        return input.split(COMMA_OR_COLON_DELIMITER);
    }

    private static boolean isNullOrEmpty(final String input) {
        return input == null || input.isBlank();
    }

    private static boolean doesNotContainAnyDelimiter(final String input) {
        return !input.startsWith(CUSTOM_DELIMITER_PREFIX)
                && !input.contains(COMMA_DELIMITER)
                && !input.contains(COLON_DELIMITER);
    }

    private static int parsePositiveSingleNumber(final String input) {
        final int singleNumber = parseSingleNumber(input);

        if (singleNumber < 0) {
            throw new RuntimeException(MESSAGE_NEGATIVE_NOT_ALLOWED);
        }

        return singleNumber;
    }

    private static int parseSingleNumber(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RuntimeException(MESSAGE_INVALID_NUMBER_FORMAT, e);
        }
    }

    private static boolean defaultDelimiterIsUsed(final String input) {
        return !input.startsWith(CUSTOM_DELIMITER_PREFIX)
                && (input.contains(COMMA_DELIMITER) || input.contains(COLON_DELIMITER));
    }

    private static int sumAfterSplitByDelimiter(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .mapToInt(StringAddCalculator::parsePositiveSingleNumber)
                .sum();
    }

    private static int sumAfterSplitByCustomDelimiter(final String input) {
        final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new RuntimeException(MESSAGE_INVALID_CUSTOM_DELIMITER_FORMAT);
        }

        final String delimiter = String.format("\\%s", matcher.group(CUSTOM_DELIMITER_CHARACTER_GROUP_NAME));
        final String inputSplitByCustomDelimiter = matcher.group(CUSTOM_DELIMITER_INPUT_GROUP_NAME);

        return sumAfterSplitByDelimiter(inputSplitByCustomDelimiter, delimiter);
    }
}
