package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int calculate(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        if (text.contains("-")) {
            throw new RuntimeException();
        }

        if (text.contains(",")) {
            String[] numbers = text.split(",|:");
            int sum = 0;
            for (String number: numbers) {
                 sum += Integer.parseInt(number);
            }
            return sum;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] token = m.group(2).split(customDelimiter);
            int sum = 0;
            for (String number: token) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }

        return Integer.parseInt(text);
    }
}
