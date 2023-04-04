import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        if (isContainsNegativeNumber(text)) {
            throw new RuntimeException("Contains a negative number.");
        }

        if (isSingleNumeric(text)) {
            return Integer.parseInt(text);
        }

        return sum(text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isSingleNumeric(String text) {
        return text.matches("\\d+");
    }

    private static boolean isContainsNegativeNumber(String text) {
        return text.contains("-");
    }

    private static int sum(String text) {
        Matcher customMatcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (customMatcher.find()) {
            return Arrays.stream(customMatcher.group(2).split(customMatcher.group(1)))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        String[] numbers = text.split(DEFAULT_SEPARATOR);
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
