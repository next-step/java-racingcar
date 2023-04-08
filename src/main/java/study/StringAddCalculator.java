package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final StringBuilder REGEX = new StringBuilder("[:,]");
    public static final int ZERO = 0;
    public static final int REGEX_INSERT_INDEX = 3;
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
    public static Matcher matcher;

    public static int splitAndSum(String text) {
        try {
            return calculatedResult(text);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    private static int calculatedResult(String text) {
        if (isNullOrBlank(text)) {
            return ZERO;
        }
        text = validatedText(text);

        return sumUsingDelimiter(text);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String validatedText(String text) {
        matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            text = textUpdate(matcher);
        }
        return text;
    }

    private static String textUpdate(Matcher matcher) {
        final int DELIMITER_INDEX = 1;
        final int NUM_LIST_INDEX = 2;

        char customDelimiter = matcher.group(DELIMITER_INDEX).charAt(0);
        addDelimiter(customDelimiter);
        return matcher.group(NUM_LIST_INDEX);
    }

    private static void addDelimiter(char customDelimiter) {
        REGEX.insert(REGEX_INSERT_INDEX, customDelimiter);
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
            throw new IllegalArgumentException("잘못된 형식으로 입력했습니다.");
        }
    }

    private static void checkIfIsNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
