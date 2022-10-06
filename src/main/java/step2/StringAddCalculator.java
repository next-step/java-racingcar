package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static int splitAndSum(String source) {
        if (isBlank(source)) {
            return 0;
        }

        String[] tokens = Tokenizer.tokenize(source);
        List<Positive> positives = toPositives(tokens);
        return sum(positives).toInteger();
    }

    private static boolean isBlank(String source) {
        return source == null || source.isEmpty();
    }

    private static Positive sum(List<Positive> positives) {
        return positives.stream()
            .reduce((x, y) -> x.add(y))
            .orElse(Positive.zero());
    }

    private static List<Positive> toPositives(String[] numbers) {
        return Arrays.stream(numbers)
            .map(token -> Positive.of(token))
            .collect(Collectors.toList());
    }
}
