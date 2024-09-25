package calculator;

import java.util.Arrays;

public class Calculator {
    public int sum(String input) {
        return sum(toInt(split(input)));
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
