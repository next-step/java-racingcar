package calculator;

import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        List<String> tokens = new InputParser(input).getTokens();
        Numbers numbers = new Numbers(tokens);
        return numbers.sum();
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
