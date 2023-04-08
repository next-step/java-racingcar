package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int NUM_STRING_INDEX = 2;
    private static final String GIVEN_DELIMITER = ",|:";
    private static final Pattern GIVEN_DELIMITER_PATTERN = Pattern.compile(GIVEN_DELIMITER);

    public static int splitAndSum(String givenValue) {
        if (isNullOrEmpty(givenValue)) {
            return ZERO;
        }
        String[] numbers = split(givenValue);
        return getTotal(numbers);
    }


    private static boolean isNullOrEmpty(String givenValue) {
        return givenValue == null || givenValue.isEmpty();
    }

    private static String[] split(String givenValue) {
        Matcher customDelimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(givenValue);
        if (customDelimiterMatcher.find()) {
            return splitByGivenDelimiter(customDelimiterMatcher.group(NUM_STRING_INDEX), customDelimiterMatcher.group(DELIMITER_INDEX));
        }
        return GIVEN_DELIMITER_PATTERN.split(givenValue);
    }

    private static String[] splitByGivenDelimiter(String givenString, String customDelimiter) {
        return givenString.split(customDelimiter);
    }

    private static int getTotal(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = toInteger(number);
            total += parsedNumber;
        }
        return total;
    }

    private static int toInteger(String number) {
        int parsedNumber = Integer.parseInt(number);
        if (parsedNumber < 0) {
            throw new IllegalArgumentException("음수를 포함하지 말아야 합니다.");
        }
        return parsedNumber;
    }
}
