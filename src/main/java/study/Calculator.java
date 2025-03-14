package study;

import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_NUMBERS_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEW_LINE = "\n";

    public static int sum(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] ints = parseInts(split(s));
        if (hasNegativeNumbers(ints)) {
            throw new RuntimeException();
        }

        return sum(ints);
    }

    private static String[] split(String s) {
        String delimiterRegex = DEFAULT_NUMBERS_DELIMITER_REGEX;
        if (s.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEnd = s.indexOf(NEW_LINE);
            delimiterRegex = Pattern.quote(s.substring(2, delimiterEnd));
            s = s.substring(delimiterEnd + 1);
        }
        return s.split(delimiterRegex);
    }

    private static int[] parseInts(String[] numberStrings) {
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        return numbers;
    }

    private static boolean hasNegativeNumbers(int[] numbers) {
        for (int number : numbers) {
            if (number < 0) {
                return true;
            }
        }
        return false;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum = sum + num;
        }
        return sum;
    }
}
