package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.*?)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

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
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);

            return m.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int[] toInt(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = toInt(values[i]);
        }

        return numbers;
    }

    private static int toInt(String values) {
        int number = Integer.parseInt(values);

        if(number < 0) {
            throw new RuntimeException("음수 입력 불가");
        }

        return number;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
