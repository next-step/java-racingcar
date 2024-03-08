package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    static int calculate(String text) {
        if (isEmptyString(text)) {
            return 0;
        }
        return sum(splitByPattern(text));
    }

    private static boolean isEmptyString(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        int result = 0;

        for (String value : values) {
            result += validateNumber(value);
        }
        return result;
    }

    private static int validateNumber(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력 가능하지 않습니다");
        }
        return number;
    }

    private static String[] splitByPattern(String text) {
        final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        Matcher matcher = pattern.matcher(text);
        return getStrings(text, matcher);
    }

    private static String[] getStrings(String text, Matcher matcher) {
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

}
