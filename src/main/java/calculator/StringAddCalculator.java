package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String SEPARATOR = ",|:";
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {

        if (isNullOrEmpty(text)) {
            return DEFAULT_VALUE;
        }

        Matcher customPattern = getMatcher(text);
        if (checkCustomPattern(customPattern)) {
            return sum(disuniteValue(customPattern));
        }

        return separatorSum(text);
    }

    private static int sum(String[] values) {
        int num = 0;
        for (String value : values) {
            num += validate(value);
        }
        return num;
    }

    private static int separatorSum(String text) {
        String[] numbers = text.split(SEPARATOR);
        return sum(numbers);
    }

    private static boolean checkCustomPattern(Matcher customPattern) {
        return customPattern.find();
    }

    private static String[] disuniteValue(Matcher customPattern) {
        String customDelimiter = customPattern.group(1);
        return customPattern.group(2).split(customDelimiter);
    }

    private static int validate(String value) {
        int number = stringToInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static int stringToInt(String value) {
        return Integer.parseInt(value);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Matcher getMatcher(String text) {
        return CUSTOM_PATTERN.matcher(text);
    }

}
