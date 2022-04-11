package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    public static final int MINIMUM = 0;

    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return MINIMUM;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = split(str);
        return sum(toInts(values));
    }

    private static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }

    private static String[] split(String str) {
        return str.split(DEFAULT_DELIMITER);
    }

    private static int[] toInts(String[] values) {
       int[] numbers = new int[values.length];
       for (int i = MINIMUM; i < values.length; i++) {
           numbers[i] = toInt(values[i]);
       }
       return numbers;
    }

    private static int sum(int[] numbers) {
        int sum = MINIMUM;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < MINIMUM) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        return number;
    }

}
