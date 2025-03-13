package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\\n(.*)").matcher(text);

        if (m.find()) {
            delimiter = Pattern.quote(m.group(1));
            text = m.group(2);
        }

        String[] tokens = text.split(delimiter);
        return sumTokens(tokens);
    }

    private static int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            int number = parseNumber(token);
            if (number < 0) {
                throw new RuntimeException("Negative numbers are not allowed: " + token);
            }
            sum += number;
        }
        return sum;
    }

    private static int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid number: " + token);
        }
    }
}
