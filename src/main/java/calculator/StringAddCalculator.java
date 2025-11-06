package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        int result;
        if (text == null || text.isEmpty()) {
            result = 0;
        } else {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter);
                result = sum(values);
            } else {
                String[] values = text.split(",|:");
                result = sum(values);
            }
        }
        return result;
    }

    private static int sum(String[] values) {
        int total = 0;
        for (String value : values) {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException("음수를 입력할 수 없습니다.");
            }
            total += number;
        }
        return total;
    }
}
