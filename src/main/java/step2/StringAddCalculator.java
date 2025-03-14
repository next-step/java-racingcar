package step2;

import java.util.List;

public class StringAddCalculator {
    private final static StringSeperator serperator = new StringSeperator();

    public static int calculate(String input) {
        List<Integer> numbers = serperator.seperate(input);
        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
