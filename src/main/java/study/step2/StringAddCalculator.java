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

        // java.util.regex 패키지의 Matcher, Pattern import
        Pattern pattern = Pattern.compile("//(.)\n(.*)");

        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(DELIMITER_INDEX);
            String[] tokens = matcher.group(TOKENS_INDEX).split(customDelimiter);

            return sum(tokens);
        }
        return sum(split(text));
    }

    static boolean isNullOrEmpty(String text) {
        if (text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        return false;

    }

    static String[] split(String text) {

        return text.split(",|:");
    }

    static int sum(String[] tokens) {

        int sum = 0;
        for (String token : tokens) {
            sum += getPositiveNumber(token);
        }
        return sum;
    }

    private static int getPositiveNumber(String token) {
        int element;
        try {
            element = Integer.parseInt(token);
            if (!isZeroOrPositive(element)) {
                throw new RuntimeException("cannot add negative number");
            }
        } catch (NumberFormatException e) {
            throw e;
        }
        return element;
    }

    static boolean isZeroOrPositive(int num) {
        return num >= 0;
    }

}
