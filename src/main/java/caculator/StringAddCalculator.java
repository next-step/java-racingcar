package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        return sumOfStrings(splitString(text));
    }

    static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    static String[] splitString(String text) {
        Matcher matcher = COMPILED_PATTERN.matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);

            return matcher.group(2).split(customSeparator);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    static int sumOfStrings(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += stringToPositiveInt(value);
        }

        return sum;
    }

    static int stringToPositiveInt(String text) {
        int number = toInt(text);

        if (number < 0) {
            throw new RuntimeException("0이상의 정수만 가능합니다");
        }

        return number;
    }

    static int toInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException("정수가 아닙니다");
        }
    }
}
