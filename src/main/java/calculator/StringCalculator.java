package calculator;

import java.util.regex.*;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER = ",|;";
    public static final String DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)){
            return ZERO;
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        return getText(text).split(getDelimiter(text));
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return DELIMITER;
    }

    private static String getText(String text) {
        Matcher m = Pattern.compile(DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            return m.group(2);
        }
        return text;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] values) {
        int sum = ZERO;
        for (int value : values) {
            sum += value;
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
        if (number < 0){
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
