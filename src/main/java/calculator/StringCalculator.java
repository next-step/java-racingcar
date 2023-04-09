package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static int ZERO = 0;
    private static final int CUSTOM_DELIMITER_GROUP_NUMBER = 1;
    private static final int TEXT_GROUP_NUMBER = 2;

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if (matcher.find()) {
            return matcher.group(TEXT_GROUP_NUMBER).split(matcher.group(CUSTOM_DELIMITER_GROUP_NUMBER));
        }
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
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
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException("음수는 입력 불가합니다.");
        }
        return number;
    }
}
