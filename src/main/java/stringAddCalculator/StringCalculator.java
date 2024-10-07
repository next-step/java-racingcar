package stringAddCalculator;

import java.util.List;

public class StringCalculator {
    public static int splitAndSum(String numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = StringCalculatorUtils.splitStringCalculator(numbers);
        List<Integer> convertedInputs = StringCalculatorUtils.convertInputs(tokens);

        return sumInputs(convertedInputs);
    }
    private static int sumInputs(List<Integer> inputs) {

        int sum = 0;
        for (Integer input : inputs) sum += input;

        return sum;
    }
}