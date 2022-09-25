package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static final String COMMA_OR_COLON = ",|:";
    public static final Pattern COMPILE = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) return 0;

        String[] factors = splitWithCommaOrColon(input);
        Matcher matcher = COMPILE.matcher(input);

        if (matcher.find()) {
            factors= matcher.group(2).split(matcher.group(1));
        }

        return add(factors);
    }

    private static int add(String[] factors) {
        int sum = 0;
        for (String factor : factors) {
            int number = getParseInt(factor);
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

    private static int getParseInt(String factor) {
        return Integer.parseInt(factor);
    }

    private static String[] splitWithCommaOrColon(String str) {
        return str.split(COMMA_OR_COLON);
    }
}
