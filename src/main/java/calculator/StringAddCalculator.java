package calculator;

import java.util.List;

public class StringAddCalculator {

    private static final Converter converter = new Converter();

    public static PositiveInteger splitAndSum(String input) {
        return sum(converter.convert(input));
    }

    public static PositiveInteger sum(List<PositiveInteger> nums) {
        PositiveInteger sum = new PositiveInteger(0);
        for (PositiveInteger num : nums) {
            sum = sum.plus(num);
        }
        return sum;
    }

}
