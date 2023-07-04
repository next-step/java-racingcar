package calculator;

import java.util.Arrays;

public class Calculator {
    public static int sum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return Arrays.stream(input.split(",|:"))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
