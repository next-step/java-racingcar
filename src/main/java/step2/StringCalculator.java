package step2;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static String DELIMITER = ",|:";
    public static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    public static final int CUSTOM_DELIMITER = 1;
    public static final int TARGET_TEXT = 2;

    public static int splitAndSum(String text) {

        if (isBlank(text)) {
            return ZERO;
        }

        return sum(convertInts(split(text)));

    }

    private static String[] split(String text) {
        Matcher regexMatcher = pattern.matcher(text);
        if (regexMatcher.find()) {
            String customDelimiter = regexMatcher.group(CUSTOM_DELIMITER);
            return regexMatcher.group(TARGET_TEXT).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] convertInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toPositive(values[i]);
            numbers[i] = number;
        }

        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
