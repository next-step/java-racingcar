package study.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_SEPARATOR = ",|:";
    public static final String CUSTOM_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return sum(toInts(split(text)));
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] toInts(String[] values) {
        return Arrays
                .stream(values)
                .mapToInt(Integer::parseInt)
                .map(StringAddCalculator::checkPositiveNumber)
                .toArray();
    }

    private static int checkPositiveNumber(int num) {
        if (num < 0) throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        return num;
    }

    private static String[] split(String text) {

        Matcher m = Pattern.compile(CUSTOM_PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_SEPARATOR);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
