package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public static int splitAndSum(String textInput) {
        if (isBlank(textInput)) {
            return ZERO;
        }

        return sum(toInts(split(textInput)));
    }

    private static String[] split(String textInput) {
        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(textInput);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            textInput = matcher.group(2);
        }

        return textInput.split(delimiter);
    }

    private static boolean isBlank(String textInput) {
        return textInput == null || textInput.isBlank();
    }

    private static int sum(int[] values) {
        int sum = ZERO;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            int number = toInt(values[i]);
            numbers[i] = number;
        }

        return numbers;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) throw new RuntimeException("음수는 입력할 수 없습니다.");
        return number;
    }

}
