package study;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        return Arrays.stream(value.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
