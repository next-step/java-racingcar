package step2_string_add_calc;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(String inputStr) {
        if (inputStr == null || inputStr.isEmpty())
            return 0;
        return Arrays.stream(inputStr.split(",|:"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}