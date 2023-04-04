package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private String[] numbers;

    public StringAddCalculator(String input) {
        numbers = splitInput(input);
    }

    private String[] splitInput(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        Matcher customDelimiterMatcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (customDelimiterMatcher.find()) {
            String customDelimiter = customDelimiterMatcher.group(1);
            return customDelimiterMatcher.group(2).split(Pattern.quote(customDelimiter));
        }
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }

    public int add() {
        int result = 0;
        for (String number : numbers) {
            int intValue = toInt(number);
            if (intValue < 0) {
                throw new RuntimeException(String.format(NEGATIVE_NUMBER_ERROR_MESSAGE, intValue));
            }
            result += intValue;
        }
        return result;
    }
}