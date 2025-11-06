package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return sum(toIntArray(split(input)));
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int sum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += toPositiveInt(num);
        }
        return total;
    }

    private static int[] toIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = parseInt(strArray[i]);
        }
        return intArray;
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static int toPositiveInt(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

}
