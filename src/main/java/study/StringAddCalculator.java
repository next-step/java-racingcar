package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final String DELIMITER = "[,:]";
    private static final String REGEX_FOR_CUSTOM_DELIMITER = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }
        return sum(toPositiveInt(split(text)));
    }

    private static int sum(int[] ints) {
        int sum = ZERO;
        for (final int i : ints) {
            sum += i;
        }
        return sum;
    }

    private static int[] toPositiveInt(String[] textArray) {
        final int[] ints = new int[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            ints[i] = toPositive(textArray[i]);
        }
        return ints;
    }

    private static int toPositive(String str) {
        final int i = Integer.parseInt(str);

        if (i < 0) {
            throw new RuntimeException("parameter must have positive number.");
        }
        return i;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return removeRegex(text).split(findDelimiter(text));
    }

    private static String removeRegex(String text) {
        final Pattern pattern = Pattern.compile(REGEX_FOR_CUSTOM_DELIMITER);
        final Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(2);
        }
        return text;
    }


    private static String findDelimiter(String text) {
        final Pattern pattern = Pattern.compile(REGEX_FOR_CUSTOM_DELIMITER);
        final Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        }
        return DELIMITER;
    }

}
