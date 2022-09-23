package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    public static final String SEPARATOR = "[,:]";
    private static final String PATTERN = "//(.)\n(.*)";


    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toInts(split(text)));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile(PATTERN).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(SEPARATOR);
    }

    private static int[] toInts(String[] values) {
        return Arrays.stream(values)
            .mapToInt(StringAddCalculator::toInt)
            .toArray();
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
