package calculator;

import java.util.List;

public class StringAddCalculator {

    private static final Converter converter = new Converter();

    public static int splitAndSum(String input) {
        List<Integer> nums = converter.convert(input);
        return sum(nums);
    }

    public static int sum(List<Integer> nums) {
        return nums.stream().reduce(0, Integer::sum);
    }

}
