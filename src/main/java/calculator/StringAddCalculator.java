package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,|:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKEN_INDEX = 2;

    public static int splitAndSum(String text) {
        int validateRsltFlag;
        int totalSum = 0;

        validateRsltFlag = validate(text);
        if (validateRsltFlag >= 0) {
            return validateRsltFlag;
        }

        validateNegativeNumberAndThrow(text);
        
        String[] numbers = splitBySeparator(text);
        for (String num : numbers) {
            totalSum += Integer.parseInt(num);
        }

        return totalSum;
    }

    private static String[] splitBySeparator(String text) {
        Matcher customMatcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (customMatcher.find()) {
            return customMatcher.group(TOKEN_INDEX)
                    .split(customMatcher.group(DELIMITER_INDEX));
        }

        return text.split(DEFAULT_SEPARATOR);
    }

    private static void validateNegativeNumberAndThrow(String text) {
        if (text.contains("-")) {
            throw new IllegalArgumentException("Contains a negative number.");
        }
    }

    private static int validate(String text) {
        if (isNullOrBlank(text)) return 0;
        validateNegativeNumberAndThrow(text);
        if (isSingleNumeric(text)) return Integer.parseInt(text);

        return -1;
    }

    private static boolean isSingleNumeric(String text) {
        return text.matches("\\d+");
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }
}