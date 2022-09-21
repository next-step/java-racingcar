package calculator;

import java.util.List;

public class AddCalculator {

    private final Converter converter;

    public AddCalculator() {
        this.converter = new Converter();
    }

    public int calculate(String input) {
        List<Integer> nums = converter.convert(input);
        return calculate(nums);
    }

    public int calculate(List<Integer> nums) {
        return nums.stream().reduce(0, Integer::sum);
    }

}
