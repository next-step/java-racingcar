import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,|:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        validateContainsNegativeNumberAndThrow(text);

        if (isSingleNumeric(text)) {
            return Integer.parseInt(text);
        }

        String[] numbers = splitNumberBySeparator(text);
        return sum(numbers);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static boolean isSingleNumeric(String text) {
        return text.matches("\\d+");
    }

    private static void validateContainsNegativeNumberAndThrow(String text) {
        if (text.contains("-")) {
            throw new IllegalArgumentException("Contains a negative number.");
        }
    }

    private static String[] splitNumberBySeparator(String text) {
        Matcher customMatcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(text);
        if (customMatcher.find()) {
            return customMatcher.group(2).split(customMatcher.group(1));
        }

        return text.split(DEFAULT_SEPARATOR);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
