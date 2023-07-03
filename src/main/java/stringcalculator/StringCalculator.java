package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    public static int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public static int[] toIntArray(String input, String[] delimiter) {
        String regex = String.join("|", delimiter);
        String[] array = input.split(regex);

        return Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
    }
}
