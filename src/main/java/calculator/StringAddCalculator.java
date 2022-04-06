package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";
    public static final String REGEX_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int result = 0;
        Matcher matcher = Pattern.compile(REGEX_PATTERN).matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String[] values = matcher.group(2).split(customSeparator);
            for (String value : values) {
                int number = Integer.parseInt(value);
                if (number < 0) {
                    throw new RuntimeException();
                }
                result += number;
            }
            return result;
        }

        String[] values = text.split(SEPARATOR);
        for (String value : values) {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException();
            }
            result += number;
        }
        return result;
    }
}
