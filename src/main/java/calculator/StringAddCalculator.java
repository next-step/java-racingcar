package calculator;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        return sum(toPositiveInts(split(text)));
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    private static String[] split(String text) {
        Matcher matcher = matchCustomDelimiterPattern(text);
        if (matcher.matches()) {
            return splitWithCustomDelimiter(matcher);
        }
        return splitWithDefaultDelimiter(text);
    }

    private static Matcher matchCustomDelimiterPattern(String text) {
        return CUSTOM_DELIMITER_PATTERN.matcher(text);
    }

    private static String[] splitWithCustomDelimiter(MatchResult matchResult) {
        String delimiter = matchResult.group(1);
        String target = matchResult.group(2);
        return splitText(target, delimiter);
    }

    private static String[] splitWithDefaultDelimiter(String text) {
        return splitText(text, DEFAULT_DELIMITER);
    }

    private static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int[] toPositiveInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = toPositiveInt(values[i]);
        }
        return result;
    }

    private static int toPositiveInt(String value) {
        int number = toInt(value);
        if (number < 0) {
            throw new RuntimeException("음수를 사용할 수 없습니다.");
        }
        return number;
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("올바르지 않은 숫자입니다.");
        }
    }

    private static int sum(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
