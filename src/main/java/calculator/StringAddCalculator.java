package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int splitAndSum(String number) {
        if (isBlank(number)) {
            return 0;
        }
        return sum(toInts(split(number)));
    }

    private static boolean isBlank(String number) {
        return number == null || number.isBlank();
    }

    private static String[] split(String text) {
        Matcher m = COMPILED_PATTERN.matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);
        if (number < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        return number;
    }

    private static int sum(int[] values) {
        int result = 0;

        for (int num : values) {
            result += num;
        }

        return result;
    }
}
