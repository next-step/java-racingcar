package edu.nextstep.camp.tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (text.length() == 1) {
            return parseAndValidate(text);
        }

        String[] numbers = getNumbers(text);
        return sum(numbers);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] getNumbers(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int parseAndValidate(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("Negative numbers are not allowed: " + value);
        }
        return number;
    }

    private static int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            total += parseAndValidate(number);
        }
        return total;
    }
}
