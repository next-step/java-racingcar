package calculator;

import parser.Parser;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        return sum(Parser.parse(input));
    }

    private static int sum(final int[] numbers) {
        int sum = 0;

        for (final int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
