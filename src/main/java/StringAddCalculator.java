import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        final Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            final String textToken = m.group(2);
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
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }
}
