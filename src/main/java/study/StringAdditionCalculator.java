package study;

import java.util.Arrays;

public class StringAdditionCalculator {
    private static final String SPLIT_REGEX = "[,:]";

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        String[] split = split(input);
        return sumOf(split);
    }

    private static String[] split(String input) {
        return input.split(SPLIT_REGEX);
    }

    private static int sumOf(String[] split) {
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
