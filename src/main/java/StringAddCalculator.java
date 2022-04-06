import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(final String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            final String customDelimiter = m.group(1);
            return sum(m.group(2).split(customDelimiter));
        }
        return sum(text.split(DEFAULT_DELIMITER));
    }

    private static int sum(final String[] values) {
        int result = 0;
        for (String value : values) {
            final int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            result += number;
        }
        return result;
    }
}
