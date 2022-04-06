import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(final String text) {
        if (text == null || text.isBlank()) {
            return 0;
        } else {
            String[] values;
            final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                final String customDelimiter = m.group(1);
                values = m.group(2).split(customDelimiter);
            } else {
                values = text.split(DEFAULT_DELIMITER);
            }
            return sum(values);
        }
    }

    private static int sum(final String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
}
