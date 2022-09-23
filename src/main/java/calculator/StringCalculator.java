package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static Matcher matcher;

    public static int parseAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        if (isCustomized(text)) {
            return sum(toInts(splitCustomizedText()));
        }
        return sum(toInts(splitDefaultText(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static boolean isCustomized(String text) {
        matcher = createMatcher(text);
        return matcher.find();
    }

    private static Matcher createMatcher(String text) {
        return Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }
        return numbers;
    }

    private static String[] splitCustomizedText() {
        String customSeparator = matcher.group(1);
        String text = matcher.group(2);
        return split(text, customSeparator);
    }

    private static String[] splitDefaultText(String text) {
        return split(text, DEFAULT_SEPARATOR);
    }

    private static String[] split(String text, String separator) {
        return text.split(separator);
    }
}
