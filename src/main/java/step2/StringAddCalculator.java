package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASE_DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens;
        if (text.contains("//")) {
            tokens = splitByCustomDelimiter(text);
            return sum(tokens);
        }

        tokens = text.split(BASE_DELIMITER);

        return sum(tokens);
    }

    private static String[] splitByCustomDelimiter(String text) {
        String[] tokens = new String[0];
        Matcher matched = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matched.find()) {
            String customDelimiter = matched.group(1);
            tokens = matched.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            validCheck(token);
            result += Integer.parseInt(token);
        }
        return result;
    }

    private static void validCheck(String token) {
        if (!isValidNumber(token)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isValidNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            return number >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
