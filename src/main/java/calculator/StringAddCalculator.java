package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    static final String DEFAULT_DELIMITER = ",|:";
    public static int splitAndSum(String text) {

        if(isBlankOrNull(text)) {
            return 0;
        }

        Matcher m = getMatcher(text);
        String delimiter = DEFAULT_DELIMITER;

        if(hasCustomDelimiter(m)) {
            delimiter = getCustomDelimiter(m);
            text = getText(m);
        }

        String[] values = split(text, delimiter);

        return sum(toIntArray(values));
    }

    private static boolean isBlankOrNull(String text) {
        return text == null || text.isBlank();
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_DELIMITER).matcher(text);
    }

    private static boolean hasCustomDelimiter(Matcher m) {
        return m.find();
    }

    private static String getCustomDelimiter(Matcher m) {
        return m.group(1);
    }

    private static String getText(Matcher m) {
        return m.group(2);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toIntArray(String[] values) {
        int size = values.length;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = getPositive(values[i]).getNumber();
        }
        return numbers;
    }

    private static Positive getPositive(String value) {
        Positive positive = new Positive(value);
        return positive;
    }
}
