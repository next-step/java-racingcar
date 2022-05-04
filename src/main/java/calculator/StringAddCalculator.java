package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values= m.group(2).split(customDelimiter);
            return sum(toInts(values));
        }
        String[] values = text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
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
        for (int i = 0; i <values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
        return number;
    }
}
