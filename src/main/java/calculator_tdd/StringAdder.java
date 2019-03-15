package calculator_tdd;

import java.util.Arrays;

public class StringAdder {
    public static int calculate(String expression) {
        String[] numbers = expression.split(",|:");

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
