package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final int RETURN_VALUE_WHEN_EMTPY_TEXT = 0;
    public static final String DEFAULT_SEPARATOR_PATTERN = ",|:";
    public static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int SEPARATOR_GROUP = 1;
    public static final int TEXT_GROUP = 2;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return RETURN_VALUE_WHEN_EMTPY_TEXT;
        }

        Matcher customMatcher = getCustomSeparatorPatternMatcher(text);
        if (customMatcher.find()) {
            String customDelimiter = customMatcher.group(SEPARATOR_GROUP);
            String[] tokens= customMatcher.group(TEXT_GROUP).split(customDelimiter);
            return sum(toInts(tokens));
        }

        String[] tokens = text.split(DEFAULT_SEPARATOR_PATTERN);
        return sum(toInts(tokens));
    }

    private static Matcher getCustomSeparatorPatternMatcher(String text) {
        return CUSTOM_SEPARATOR_PATTERN.matcher(text);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] tokens) {
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = toInt(tokens[i]);
        }
        return numbers;
    }

    private static int toInt(String token) {
        int number = Integer.parseInt(token);
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }

        return number;
    }
}
