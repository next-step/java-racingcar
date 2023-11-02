package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int TOKENS_GROUP = 2;
    public static int splitAndSum(String text) {
        int sum = 0;
        if (isNullOrBlank(text)) {
            return 0;
        };
        if (text.contains("-")) throw new RuntimeException("음수를 전달받은 경우 예외 발생");
        for (String str : splitText(text)) {
            sum += Integer.parseInt(str);
        }
        return sum;
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] splitText(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            String[] tokens= m.group(TOKENS_GROUP).split(customDelimiter);
            return tokens;
        } else {
            return text.split(DEFAULT_DELIMITERS);
        }
    }
}
