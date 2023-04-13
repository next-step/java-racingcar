package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String REGEX_WITH_CUSTOM = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }


    private static String[] split(String text) {
        Pattern p = Pattern.compile(REGEX_WITH_CUSTOM);
        Matcher m = p.matcher(text);

        if (m.matches()){
            String CUSTOM = m.group(1);

            return m.group(2).split(CUSTOM);
        }


        return text.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
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
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
