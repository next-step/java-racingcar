package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    public static final StringBuilder REGEX = new StringBuilder("[:,]");

    public static int splitAndSum(String text) {
        try {
            return calculatedResult(text);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculatedResult(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        text = validatedText(text);
        return sumUsingDelimiter(text);
    }

    private static int sumUsingDelimiter(String text) {
        int sum = 0;
        String[] split = text.split(REGEX.toString());
        for (String s : split) {
            int num = Integer.parseInt(s);
            checkIfIsNegative(num);
            sum += num;
        }
        return sum;
    }

    private static String validatedText(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            text = textUpdate(matcher);
        }
        return text;
    }

    private static String textUpdate(Matcher matcher) {
        char customDelimiter = matcher.group(1).charAt(0);
        addDelimiter(customDelimiter);
        return matcher.group(2);
    }

    private static void addDelimiter(char customDelimiter) {
        REGEX.insert(3, customDelimiter);
    }

    private static void checkIfIsNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
