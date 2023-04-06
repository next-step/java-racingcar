package study;

import java.util.Arrays;

public class StringAdditionCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        String[] operands = operandsOf(input);
        return sumOf(operands);
    }

    private static String[] operandsOf(String input) {
        return input.split(DEFAULT_DELIMITER_REGEX);
    }

    private static int sumOf(String[] operands) {
        return Arrays.stream(operands)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
