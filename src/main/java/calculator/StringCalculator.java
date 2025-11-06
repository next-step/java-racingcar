package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] result = input.split(",|:");
        return Arrays.stream(result).mapToInt(Integer::parseInt).sum();
    }
}
