package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {

        if (text == null) {
            return 0;
        }

        if (text.isEmpty()) {
            return 0;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    public static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public static int sum(String[] tokens) {
        int result = 0;

        for (String token : tokens) {
            int parseIntToken = Integer.parseInt(token);

            if (parseIntToken < 0) {
                throw new ValidateNegative();
            }
            result = result + parseIntToken;
        }

        return result;
    }

}
