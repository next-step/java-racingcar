package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String ERROR_NEGATIVE_NUMBER = "음수는 더할 수 없습니다.";

    public static int splitAndSum(String text) throws RuntimeException {
        if (isEmpty(text)) {
            return 0;
        }

        String[] splitedString = splitFrom(text);
        return calculateSum(splitedString);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitFrom(String text) {
        if (hasCustomDelimiter(text)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDefaultDelimiter(text);
    }

    private static boolean hasCustomDelimiter(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        return matcher.find();
    }

    private static String[] splitByCustomDelimiter(String text) {
        Matcher matcher = getCustomDelimiterMatcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return new String[0];
    }


    private static String[] splitByDefaultDelimiter(String text) {
        return text.split(DEFAULT_DELIMITERS);
    }

    private static Matcher getCustomDelimiterMatcher(String text) {
        return Pattern.compile(StringAddCalculator.CUSTOM_DELIMITER_PATTERN).matcher(text);
    }

    private static int calculateSum(String[] stringArr) throws RuntimeException {
        int sum = 0;
        for (String each : stringArr) {
            int num = parseIntFrom(each);
            validateIsNotNegative(num);
            sum += num;
        }
        return sum;
    }

    private static int parseIntFrom(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void validateIsNotNegative(int num) throws RuntimeException {
        if (num < 0) {
            throw new RuntimeException(ERROR_NEGATIVE_NUMBER);
        }
    }


}
