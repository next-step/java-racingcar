package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    public static final StringBuilder REGEX = new StringBuilder("[:,]");

    public static int splitAndSum(String text) {
        try {
            return calculatedResult(text);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculatedResult(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        text = validatedText(text);

        System.out.println("text = " + text);
        return sumUsingDelimiter(text);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String validatedText(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            text = textUpdate(matcher);
        }
        return text;
    }

    private static String textUpdate(Matcher matcher) {
        final int DELIMITER_INDEX = 1;
        final int NUM_LIST_INDEX = 2;

        char customDelimiter = matcher.group(DELIMITER_INDEX).charAt(0);
        System.out.println("customDelimiter = " + customDelimiter);
        addDelimiter(customDelimiter);
        return matcher.group(NUM_LIST_INDEX);
    }

    private static void addDelimiter(char customDelimiter) {
        REGEX.insert(3, customDelimiter);
    }

    private static int sumUsingDelimiter(String text) {
        int sum = 0;
        String[] splitNum = text.split(REGEX.toString());
        for (String stringNumber : splitNum) {
            int convertedNum = convertedNum(stringNumber);
            checkIfIsNegative(convertedNum);
            sum += convertedNum;
        }
        return sum;
    }

    private static int convertedNum(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static void checkIfIsNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        int i = splitAndSum("//ab\n1:2,3");
        System.out.println(i);
    }
}
