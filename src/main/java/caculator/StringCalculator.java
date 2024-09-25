package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        String regexForSplit = makeRegexForSplit();
        String[] tokens = text.split(regexForSplit);
        List<Integer> parsedNumbers = parseTokens(tokens);
        int sum = sum(parsedNumbers);

        return sum;
    }

    private static String makeRegexForSplit() {
        return "[" + COMMA + COLON + "]";
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
