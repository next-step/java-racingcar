package calculator;

import java.util.List;

public class StringSumCalculator {
    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Tokenizer tokenizer = new Tokenizer(input);
        return sum(toNonNegativeNumbers(tokenizer.tokens()));
    }

    private static List<NonNegativeNumber> toNonNegativeNumbers(List<String> tokens) {
        return tokens.stream().map(NonNegativeNumber::new).toList();
    }

    private static int sum(List<NonNegativeNumber> numbers) {
        return numbers.stream().mapToInt(NonNegativeNumber::getValue).sum();
    }
}
