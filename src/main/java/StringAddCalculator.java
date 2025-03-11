import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = "[,:;]";
    private static final String DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(DELIMITER_REGEX);

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isBlank()) {
            return 0;
        }
        return sum(toInt(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (!matcher.find()) {
            return text.split(DELIMITER);
        }

        String customDelimiter = matcher.group(1);
        String delimitedText = matcher.group(2);
        return delimitedText.split(customDelimiter);
    }

    private static int[] toInt(String[] texts) {
        return Arrays.stream(texts)
            .mapToInt(StringAddCalculator::toIntOrThrow)
            .toArray();
    }

    private static int toIntOrThrow(String text) {
        try {
            int parsedValue = toInt(text);
            if (parsedValue < 0) {
                throw new NumberFormatException();
            }
            return parsedValue;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }

    private static int sum(int[] values) {
        return Arrays.stream(values)
            .sum();
    }
}
