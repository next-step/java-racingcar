package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if(matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
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
