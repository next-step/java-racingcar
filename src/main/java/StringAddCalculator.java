import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER = 1;
    private static final int TEXT = 2;

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] tokens = token(text);
        if (negative(tokens)) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다!");
        }

        return sum(tokens);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] token(String text) {
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER);
            return m.group(TEXT).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static boolean negative(String[] tokens) {
        return Arrays.stream(tokens)
                .anyMatch(x -> Integer.parseInt(x) < 0);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
