package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String[] tokens = text.split(",");
        List<Integer> parsedNumbers = parseTokens(tokens);
        int sum = sum(parsedNumbers);

        return sum;
    }

    private static List<Integer> parseTokens(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }
}
