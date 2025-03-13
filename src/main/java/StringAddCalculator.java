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

        String delimiter = findDelimiter(text);
        String textToSplit = findTextToSplit(text);
        return sum(toInts(split(textToSplit, delimiter)));
    }

    private static String findDelimiter(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (!matcher.find()) {
            return DELIMITER;
        }
        return matcher.group(1);
    }

    private static String findTextToSplit(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (!matcher.find()) {
            return text;
        }
        return matcher.group(2);
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int[] toInts(String[] texts) {
        return Arrays.stream(texts)
            .mapToInt(StringAddCalculator::toInt)
            .toArray();
    }

    private static int toInt(String text) {
        int parsedValue = Integer.parseInt(text);
        validate(parsedValue);
        return parsedValue;
    }

    private static void validate(int value) {
        if (value < 0) {
            throw new RuntimeException();
        }
    }

    private static int sum(int[] values) {
        return Arrays.stream(values)
            .sum();
    }
}
