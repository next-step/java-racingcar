import java.util.List;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    private static final int ZERO = 0;

    public static Integer calculate(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO;
        }

        List<String> tokens = StringSplitter.split(text);

        return numericPositiveSum(tokens);
    }

    private static int numericPositiveSum(List<String> tokens) {
        return tokens.stream()
                .map(Positive::new)
                .mapToInt(Positive::toInteger)
                .sum();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

}
