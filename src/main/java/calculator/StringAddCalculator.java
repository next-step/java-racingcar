package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static final String DEFAULT_DELIMITER = ",|:";
    static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        int result = 0;

        if (checkNullOrEmpty(text)) {
            return result;
        }

        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

        if (m.find()) {
            String[] values = splitCustomDelimiter(m);

            return sum(toInts(values));
        }

        String[] values = split(text, DEFAULT_DELIMITER);

        return sum(toInts(values));
    }

    private static String[] splitCustomDelimiter(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static boolean checkNullOrEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static int[] toInts(String[] strings) {
        int[] values = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            values[i] = toInt(strings[i]);
        }

        return values;
    }

    private static int sum(int[] values) {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    private static int toInt(String value) {
        int number = Integer.parseInt(value);

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }
}
