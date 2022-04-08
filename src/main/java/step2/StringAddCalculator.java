package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
        if (matcher.find()) {
            return sum(toInts(split(matcher.group(2), matcher.group(1))));
        }
        return sum(toInts(split(text, DEFAULT_DELIMITER)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if(number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        return number;
    }
}
