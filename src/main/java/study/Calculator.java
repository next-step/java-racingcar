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

        return add(parseNonNegativeInts(split(s)));
    }

    private static String[] split(String s) {
        String delimiter = computeDelimiter(s);
        String stringToSplit = extractStringToSplit(s);
        return stringToSplit.split(delimiter);
    }

    private static String computeDelimiter(String s) {
        if (s.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEnd = s.indexOf(NEW_LINE);
            return Pattern.quote(s.substring(2, delimiterEnd));
        }
        return DEFAULT_NUMBERS_DELIMITER_REGEX;
    }

    private static String extractStringToSplit(String s) {
        if (s.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterEnd = s.indexOf(NEW_LINE);
            return s.substring(delimiterEnd + 1);
        }
        return s;
    }

    private static int[] parseNonNegativeInts(String[] numberStrings) {
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = parseNonNegativeInt(numberStrings[i]);
        }
        return numbers;
    }

    private static int parseNonNegativeInt(String numberStrings) {
        int num = Integer.parseInt(numberStrings);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

    private static int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum = sum + num;
        }
        return sum;
    }
}
