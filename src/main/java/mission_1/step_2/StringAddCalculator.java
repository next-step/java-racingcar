package mission_1.step_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final static String DEFAULT_DELIMITER = "[,:]";
    private final static String CUSTOM_DELIMITER  = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) return 0;

        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        String[] values  = text.split(DEFAULT_DELIMITER);
        Matcher  matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            values = matcher.group(2).split(customDelimiter);
        }

        return values;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(values[i]);
        }

        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) throw new RuntimeException("음수는 허용되지 않습니다.");
        return number;
    }
}