package calculator;

import static java.lang.Integer.parseInt;

public class TextCalculator {
    public static int calculate(String input) {
        return sum(transfer(Text.input(input).elements()));
    }

    private static Integer[] transfer(String[] elements) {
        Integer[] nums = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            int num = parseInt(elements[i]);
            checkPositive(num);
            nums[i] = num;
        }
        return nums;
    }

    private static int sum(Integer[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
        }
        return sum;
    }

    private static void checkPositive(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
    }
}
