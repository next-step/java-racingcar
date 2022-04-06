import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";

    public static int splitAndSum(final String text) {
        int result = 0;
        if (text == null || text.isBlank()) {
            result = 0;
        } else {
            String[] values;
            final Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                final String customDelimiter = m.group(1);
                values = m.group(2).split(customDelimiter);
            } else {
                values = text.split(DEFAULT_DELIMITER);
            }
            for (String value : values) {
                result += Integer.parseInt(value);
            }
        }
        return result;
    }
}
