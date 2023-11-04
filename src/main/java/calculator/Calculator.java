package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final String DELIMITER_JOIN = "|";
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int NULL_VALUE = 0;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int cal(String text) {
        if (isBlank(text)) {
            return NULL_VALUE;
        }

        return sum(toInts(splitText(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitText(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            return m.group(2).split(makeDelimiters(m.group(1)));
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static String makeDelimiters(String customerDelimiter) {
        return String.join(DELIMITER_JOIN, DEFAULT_DELIMITER, customerDelimiter);
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = parsePositiveInt(values[i]);
        }
        return numbers;
    }

    private static int parsePositiveInt(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new IllegalArgumentException("음수 값은 허용되지 않습니다.");
        }
        return number;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
