package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculatorTest {
    public static int splitAndSum(String text) {
        int result = 0;
        if (text == null || text.isBlank()) {
            result = 0;
        } else {
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter);
                sum(values, result);
            } else {
                String[] values = text.split(",|:");
                sum(values, result);
            }
        }
        return result;
    }

    private static int sum(String[] values, int result) {
        for (String value: values) {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new RuntimeException("Negative number is not accepted.");
            }
            result += number;
        }
        return result;
    }
}
