package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int sum(final String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return sumNumbers(getNumberArray(getSplit(text)));
    }

    private static int[] getNumberArray(String[] split) {
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    private static int sumNumbers(int[] split) {
        int result = 0;
        for (int number : split) {
            result += number;
        }
        return result;
    }

    private static String[] getSplit(String text) {
        String[] split = text.split(DEFAULT_DELIMITER);
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            split = matcher.group(2).split(customDelimiter);
        }
        return split;
    }

}
