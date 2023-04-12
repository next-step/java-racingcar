package stringcalculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";
    private static final String MINUS = "-\\d+";
    private static final String NOT_NUMBER = "\\D+";
    private static final String CUSTOM_SPLIT_DELIMITER = "//|\n";
    private StringAddCalculator() {
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        return sum(toInts(split(input)));
    }

    private static String[] split(String input) {
        if (isCustomDelimiterSplit(input)) {
            return customSplit(input);
        }
        return input.split(DELIMITER);
    }

    private static String[] customSplit(String input) {
        String[] split = input.split(CUSTOM_SPLIT_DELIMITER);
        String customDelimiter = split[1];
        input = split[2];
        return input.split(customDelimiter);
    }

    private static boolean isCustomDelimiterSplit(String input) {
        return Pattern.compile("//(.)\n(.*)").matcher(input).find();
    }

    private static int[] toInts(String[] split) {
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            validate(split[i]);
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }

    private static int sum(int[] ints) {
        int sum = 0;
        for (int i : ints) {
            sum += i;
        }
        return sum;
    }

    private static void validate(String input) {
        if (input.matches(MINUS) || input.matches(NOT_NUMBER)) {
            throw new RuntimeException();
        }
    }
}
