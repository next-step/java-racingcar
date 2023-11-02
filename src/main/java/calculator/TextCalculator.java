package calculator;

import static java.lang.Integer.parseInt;

public class TextCalculator {
    public static int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        return sum(transfer(Text.input(input).getElements()));
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static Integer[] transfer(String[] elements) {
        Integer[] nums = new Integer[elements.length];
        for (int i = 0; i < elements.length; i++) {
            nums[i] = parseInt(elements[i]);
        }
        return nums;
    }

    private static int sum(Integer[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            checkPositive(num);
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
