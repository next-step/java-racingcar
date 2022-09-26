package step2.calculator;

import step2.exception.ValidateNegative;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_SEPARATOR = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {

        if (text == null) {
            return ZERO;
        }

        if (text.isEmpty()) {
            return ZERO;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    public static String[] split(String text) {
        Matcher m = isCustomSeparator(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public static int sum(String[] tokens) {
        int result = ZERO;

        for (String token : tokens) {
            int parseIntToken = Integer.parseInt(token);

            validateNegative(parseIntToken);

            result = result + parseIntToken;
        }

        return result;
    }

    public static Matcher isCustomSeparator(String text) {
        return CUSTOM_SEPARATOR.matcher(text);
    }

    public static void validateNegative(int parseIntToken) {
        if (parseIntToken < ZERO) {
            throw new ValidateNegative();
        }
    }

}
