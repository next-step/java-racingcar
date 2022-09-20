package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {

        if (isNullOfEmpty(text)) {
            return 0;
        }

        String[] tokens = splitTokens(text);

        if (hasNegativeNumber(tokens)) {
            throw new RuntimeException();
        }

        Integer result = 0;

        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }

    public static boolean isNullOfEmpty(String input) {
        if (input == null) {
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }
    public static String[] splitTokens(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            return tokens;
        }

        return input.split(",|:");
    }

    public static boolean hasNegativeNumber(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 0);
    }
}
