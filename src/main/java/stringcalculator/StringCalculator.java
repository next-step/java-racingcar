package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    public static int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
