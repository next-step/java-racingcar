package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DELIMITER = ",|:";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final int DEFAULT_RETURN = 0;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return DEFAULT_RETURN;
        }

        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DELIMITER);
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
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }
}
