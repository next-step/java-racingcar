package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int TEXT = 2;

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            return m.group(TEXT).split(m.group(CUSTOM_DELIMITER));
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] split) {
        int sum = 0;

        for (String s : split) {
            sum += parseInt(s);
        }

        return sum;
    }

    private static int parseInt(String s) {
        int parseInt = Integer.parseInt(s);

        if (parseInt < 0) {
            throw new RuntimeException("음수 값이 입력됨" + parseInt);
        }

        return parseInt;
    }
}