package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

public class StringAddCalculator {
    // 메서드는 가장 작은 단위로 분리!
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            String[] values = split(m.group(2), customDelimiter);
            return sum(toInts(values));
        }
        String[] values = split(text, DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text, String defaultDelimiter) {
        String[] values = text.split(defaultDelimiter);
        return values;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
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
