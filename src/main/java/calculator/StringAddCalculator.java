package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int calculateSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sumValues(toInts(splitValues(text)));
    }

    private static String[] splitValues(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            checkInvalid(values[i]);
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static void checkInvalid(String values) {
        int num = Integer.parseInt(values);
        if (num < 0) {
            throw new IllegalArgumentException("음수는 계산되지 않습니다.");
        }
    }

    private static int sumValues(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
