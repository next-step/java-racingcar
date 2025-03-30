import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);
    public static final int CUSTOM_DELIMITER_GROUP = 1;
    public static final int TEXT_TOKEN_GROUP = 2;

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        final Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            final String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
            final String textToken = matcher.group(TEXT_TOKEN_GROUP);
            return sum(validateNegative(toInts(split(textToken, customDelimiter))));
        }
        return sum(validateNegative(toInts(split(text, DELIMITER))));
    }

    private static boolean isNullOrBlank(String text) {
        return Objects.isNull(text) || text.isBlank();
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static int[] toInts(String[] values) {
        final int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = getParseInt(values[i]);
        }
        return result;
    }

    private static int[] validateNegative(int[] values) {
        for (int value : values) {
            if (value < 0) {
                throw new RuntimeException("have negative value");
            }
        }
        return values;
    }

    private static int getParseInt(String values) {
        return Integer.parseInt(values);
    }

    private static int sum(int[] values) {
        return Arrays.stream(values).sum();
    }
}
