package woowacamp.calculator;

import java.util.List;

public class StringCalculator {
    public static int sum(String text) {
        List<Integer> numbers = SplitUtils.convertToNumbers(text);
        return Calculator.sum(numbers);
    }
}
