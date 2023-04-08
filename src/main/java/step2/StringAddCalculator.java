package step2;

import java.util.Arrays;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        final CalculatorAdaptor calculatorAdaptor = new CalculatorAdaptor(input);
        return sum(calculatorAdaptor.adapt());
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
