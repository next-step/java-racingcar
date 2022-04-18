package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final int MINIMUM = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final Pattern PATTERNCASING = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    private StringAddCalculator() {
    }

    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return MINIMUM;
        }

        Matcher m = PATTERNCASING.matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(FIRST);
            String[] values = m.group(SECOND).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = str.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isBlank(String str) {
        return str == null || str.isBlank();
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
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
        return number;
    }

}
