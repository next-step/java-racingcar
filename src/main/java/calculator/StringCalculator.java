package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_FIND_REGEX = "//(.*)\n(.*)";

    public static int splitAndSum(String text) {
        int sum = ZERO;
        if (isBlank(text)) {
            return sum;
        }

        sum = sum(getNumbers(split(text)));
        return sum;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] getNumbers(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = getPositiveNumber(new PositiveNumber(stringNumbers[i]));
        }
        return numbers;
    }

    private static int getPositiveNumber(PositiveNumber positiveNumber) {
        return positiveNumber.valueOf();
    }

    private static String[] split(String text) {
        if (!text.matches(CUSTOM_DELIMITER_FIND_REGEX)) {
            return text.split(DEFAULT_DELIMITER);
        }
        return customDelimiterSplit(text);
    }

    private static String[] customDelimiterSplit(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_FIND_REGEX).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String targetText = matcher.group(2);
            String delimiter = DEFAULT_DELIMITER + "|" + customDelimiter;

            return targetText.split(delimiter);
        }
        throw new RuntimeException("Wrong custom delimiter");
    }
}
