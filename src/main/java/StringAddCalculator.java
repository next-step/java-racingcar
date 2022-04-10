import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    public static final int CUSTOM_DELIMITER_INDEX = 1;
    public static final int NUMBER_INDEX = 2;
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static int splitAndSum(final String text) {
        if (isBlank(text)) {
            return 0;
        }
        final Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            final String[] values = m.group(NUMBER_INDEX).split(customDelimiter);
            return sum(toInts(values));
        }
        final String[] values = text.split(DEFAULT_DELIMITER);
        return sum(toInts(values));
    }

    private static boolean isBlank(final String text) {
        return text == null || text.isBlank();
    }

    private static int sum(final int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int[] toInts(final String[] values) {
        final int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toInt(values[i]);
        }
        return numbers;
    }

    private static int toInt(final String value) {
        final int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }
}
