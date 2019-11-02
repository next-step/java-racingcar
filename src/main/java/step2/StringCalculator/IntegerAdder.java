package step2.StringCalculator;

import java.util.List;

public class IntegerAdder {
    private final Parser parser;

    public IntegerAdder(String rawInput) {
        this.parser = new Parser(rawInput);
    }

    public int calculate() {
        List<Integer> nums = parser.parse();

        if (isContainsNegative(nums)) {
            throw new RuntimeException();
        }

        return nums.stream()
                .reduce(Integer::sum).orElse(0);
    }

    private boolean isContainsNegative(List<Integer> nums) {
        return nums.stream()
                   .anyMatch(num -> num < 0);
    }
}
