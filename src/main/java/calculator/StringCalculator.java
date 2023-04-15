package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final int SECOND = 2;
    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(text);
        if (matcher.find()) {
            String firstCustomDelimiter = matcher.group(FIRST);
            return matcher.group(SECOND).split(firstCustomDelimiter);
        }
        return text.split(DELIMITER);
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

    private static int[] toPositives(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int number = toPositive(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}