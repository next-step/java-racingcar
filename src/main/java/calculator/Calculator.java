package calculator;

import java.util.Arrays;

public class Calculator {
    public int sum(String input) {
        if (isEmpty(input)) return 0;
        return sum(toInt(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty() || input.isBlank();
    }

    private int sum(int[] input) {
        return Arrays.stream(input).sum();
    }

    private int[] toInt(String[] input) {
        return Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
    }

    private String[] split(String input) {
        return input.split("[:,]");
    }
}
