package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.*?)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        return sum(toInt(split(text)));
    }

    private static int sum(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);

            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
