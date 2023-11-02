package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
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
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        } else {
            return text.split(",|:");
        }
    }
}
