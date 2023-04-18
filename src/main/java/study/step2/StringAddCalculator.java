package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DELIMITER_INDEX = 1;
    private static final int TOKENS_INDEX = 2;


    static int splitAndSum(String text) {


        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private static String[] split(String text) {
        final Pattern pattern = Pattern.compile("//(.)\n(.*)");

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_INDEX);
            return matcher.group(TOKENS_INDEX).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(String[] tokens) {

        int sum = 0;
        for (String token : tokens) {
            sum += getPositiveNumber(token);
        }
        return sum;
    }

    private static int toNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    private static int getPositiveNumber(String token) {

        int num = toNumber(token);
        if (num < 0) {
            throw new NumberFormatException("cannot add negative number");
        }

        return num;
    }

}
