package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static int calculateSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sumValues(toInts(splitValues(text)));
    }

    private static String[] splitValues(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            validateNumber(values[i]);
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static void validateNumber(String value) {
        int number = parseNumber(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수는 계산되지 않습니다.");
        }
    }

    private static int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값이 입력되었습니다.");
        }
    }

    private static int sumValues(int[] values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
