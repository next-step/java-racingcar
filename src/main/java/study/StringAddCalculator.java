package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern compile = Pattern.compile(CUSTOM_DELIMITER_REGEXP);
    
    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        Matcher matcher = compile.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = split(matcher.group(2), customDelimiter);
            return sum(toInts(values));
        }
        String[] values = split(text, DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int valuesLength = values.length;
        int[] numbers = new int[valuesLength];
        for (int i = 0; i < valuesLength; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        return number;
    }

    private static String[] split(String text, String defaultDelimiter) {
        return text.split(defaultDelimiter);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
