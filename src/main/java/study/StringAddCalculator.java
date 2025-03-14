package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String REGEX = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        String[] tokens = splitText(text);

        int sum = 0;
        for (String token : tokens) {
            sum = sum + toPositiveInt(token);
        }

        return sum;
    }

    public static String[] splitText(String text) {
        Matcher m = Pattern.compile(REGEX).matcher(text);
        if (m.find()) {
            String customSeparator = m.group(1);
            text = m.group(2);
            return text.split(DEFAULT_DELIMITER + "|" + customSeparator);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    public static int toPositiveInt(String text) throws RuntimeException {
        int number = parseInt(text);

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }

    public static int parseInt(String text) throws RuntimeException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }
}
