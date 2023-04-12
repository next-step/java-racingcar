package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;

    public static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = pattern.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return (text == null || text.isBlank());
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = new Positive(values[i]).getNumber();
            numbers[i] = number;
        }
        return numbers;
    }
}
