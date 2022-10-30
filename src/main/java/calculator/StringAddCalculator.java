package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    public static final int SPLIT_FIRST = 1;
    public static final int SPLIT_SECOND = 2;
    public static final Pattern customSeparatorPattern = Pattern.compile(CUSTOM_SEPARATOR);

    public static int splitAndAddString(String numbersText) {
        if (isEmptyText(numbersText)) {
            return 0;
        }

        return add(stringArrayToIntArray(split(numbersText)));
    }

    private static String[] split(String numbersText) {
        Matcher customSeparatorMatcher = customSeparatorPattern.matcher(numbersText);

        if (containCustomSeparator(customSeparatorMatcher)) {
            String customDelimiter = customSeparatorMatcher.group(SPLIT_FIRST);
            return customSeparatorMatcher.group(SPLIT_SECOND).split(customDelimiter);
        }

        return numbersText.split(SEPARATOR);
    }

    private static boolean containCustomSeparator(Matcher m) {
        return m.find();
    }

    public static List<Integer> stringArrayToIntArray(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (String number : numbers) {
            result.add(textToInt(number));
        }

        return result;
    }

    private static int add(List<Integer> numbers) {
        int result = 0;

        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    private static int textToInt(String text) {
        int number = Integer.parseInt(text);

        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private static boolean isEmptyText(String numbersText) {
        return numbersText == null || numbersText.isEmpty();
    }
}
