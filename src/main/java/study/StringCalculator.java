package study;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final int ZERO = 0;
    public static final String DELEMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) return ZERO;
        return sum(PositiveIntConverter.toPositiveInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELEMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(List<Integer> values) {
        int sum = ZERO;
        for (int number : values) {
            sum += number;
        }
        return sum;
    }
}
