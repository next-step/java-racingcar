package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return DEFAULT_VALUE;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sum(tokens);
        }

        return sum(split(text));
    }

    private static String[] split(String text) {
        return text.split(",|:");
    }

    private static int sum(String[] text) {
        checkExistNegative(text);
        return Arrays.stream(text)
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElse(DEFAULT_VALUE);
    }

    private static void checkExistNegative(String[] text) {
        if (hasNegative(text)) {
            throw new RuntimeException("음수 값은 허용되지 않습니다.");
        }
    }

    private static boolean hasNegative(String[] text) {
        return Arrays.stream(text)
                .map(Integer::parseInt)
                .anyMatch(StringAddCalculator::isNegative);
    }

    private static boolean isNegative(Integer it) {
        return it < 0;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }
}
