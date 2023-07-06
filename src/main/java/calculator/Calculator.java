package calculator;

import java.util.Arrays;

public class Calculator {
    private static final int ZERO = 0;

    private final Splitter splitter;

    Calculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int splitAndSum(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(split(input));
    }

    private String[] split(String input) {
        return splitter.split(input);
    }

    private int sum(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(this::toInt)
                .sum();
    }

    private int toInt(String input) {
        return new PositiveNumber(input).getValue();
    }

    private boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
