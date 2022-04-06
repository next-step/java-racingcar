package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEXP);

    public static int splitAndSum(String text) {
        if(text == null || text.isBlank()){
            return 0;
        }

        Matcher m = PATTERN.matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return split(customDelimiter, m.group(2));
        }

        return split(DEFAULT_DELIMITER, text);
    }

    private static int split(String delimiter, String text) {
        String[] tokens = text.split(delimiter);
        return sum(tokens);
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            int num = toInt(value);
            result += num;
        }
        return result;
    }

    private static int toInt(String value) {
        int num = Integer.parseInt(value);
        if(num < 0) {
            throw new RuntimeException("음수는 허용하지 않습니다.");
        }
        return num;
    }
}
