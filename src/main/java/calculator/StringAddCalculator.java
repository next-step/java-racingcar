package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern TEXT_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_SEPARATOR = ",|:";
    private static final int CUSTOM_SEPARATOR_GROUP = 1;
    private static final int USER_TEXT_GROUP = 2;

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private static String[] split(String text) {
        Matcher matcher = TEXT_PATTERN.matcher(text);
        if (matcher.find()) {
            return customSplit(matcher);
        }
        return basicSplit(text);
    }

    private static String[] customSplit(Matcher matcher) {
        String customDelimiter = matcher.group(CUSTOM_SEPARATOR_GROUP);
        return matcher.group(USER_TEXT_GROUP).split(customDelimiter);
    }

    private static String[] basicSplit(String text) {
        return text.split(BASIC_SEPARATOR);
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static List<Integer> toInts(String[] tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(positive(token));
        }
        return numbers;
    }

    private static int positive(String text) {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수 값이 들어올 수 없습니다.");
        }
        return number;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}