package step2;

import java.util.List;

public class StringAddCalculator {
    private final static StringSeperator serperator = new StringSeperator();

    public static int Calculate(String input) {
        List<Integer> numbers = serperator.Seperate(input);
        return sum(numbers);
    }

    private static int sum(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }
}
