package calculator;

import java.util.Arrays;

public class Calculator {
    public int sum(String input) {
        if (isEmpty(input)) return 0;
        return sum(toInts(split(input)));
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private int sum(int[] input) {
        return Arrays.stream(input).sum();
    }

    private int[] toInts(String[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = toPositive(input[i]);
        }
        return result;
    }

    private int toPositive(String value) {
        if (isNotPositive(value)) throw new RuntimeException("양수가 아닙니다.");
        return Integer.parseInt(value);
    }

    private boolean isNotPositive(String value) {
        return !value.matches("^\\d+$");
    }

    private String[] split(String input) {
        return input.split("[:,]");
    }
}
