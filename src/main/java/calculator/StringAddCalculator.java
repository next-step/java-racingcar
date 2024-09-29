package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }

        String[] numbers = splitNumbers(input);

        return sum(numbers);
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] splitNumbers(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String numbersString = matcher.group(2);

            return numbersString.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .peek(this::validateNegative)
                .sum();

    }

    private void validateNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
