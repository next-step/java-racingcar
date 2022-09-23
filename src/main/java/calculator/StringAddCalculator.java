package calculator;

import static java.lang.Integer.parseInt;

import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SEPARATORS = "[,:]";
    private static final String CUSTOM_SEPARATOR_PATTERN = "//(.)\n(.*)";
    private static final String POSITIVE_INT_PATTERN = "[0-9]";

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        return sum(split(value));
    }

    private static String[] split(String value) {
        if (isUsedCustomSeparator(value)) {
            return value.split(value.split("\n")[0].substring(2));
        }

        return value.split(SEPARATORS);
    }

    private static boolean isUsedCustomSeparator(String value) {
        return Pattern.matches(CUSTOM_SEPARATOR_PATTERN, value);
    }

    private static int sum(String[] value) {
        int result = 0;
        for (String token : value) {
            result += parsePositiveInt(token);
        }

        return result;
    }

    private static int parsePositiveInt(String value) {
        if (isImpossibleToParse(value)) {
            throw new RuntimeException("허용하지 않는 값이 존재합니다.");
        }

        return parseInt(value);
    }

    private static boolean isImpossibleToParse(String value) {
        return !Pattern.matches(POSITIVE_INT_PATTERN, value);
    }
}
