package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int NUMBER_GROUP = 2;

    public static int splitAndSum(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (m.find()) {
            delimiter = Pattern.quote(m.group(CUSTOM_DELIMITER_GROUP));
            text = m.group(NUMBER_GROUP);
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


