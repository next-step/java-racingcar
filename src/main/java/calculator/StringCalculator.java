package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String COMMA_OR_COLON = ",|:";

    public static int splitAndSum(String input) {
        if (input.isBlank()) return 0;

        String[] tokens;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens= m.group(2).split(customDelimiter);
        } else {
            tokens = splitWithCommaOrColon(input);
        }

        int sum = 0;
        for (String c : tokens) {
            int number = getParseInt(c);
            isPositive(number);

            sum += number;
        }
        return sum;
    }

    private static void isPositive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    private static int getParseInt(String c) {
        return Integer.parseInt(c);
    }

    private static String[] splitWithCommaOrColon(String s) {
        return s.split(COMMA_OR_COLON);
    }
}
