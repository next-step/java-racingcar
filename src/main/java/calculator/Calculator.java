package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final int ZERO = 0;

    private static final int ONE = 1;

    private static final int TWO = 2;

    private static final Pattern numberPattern = Pattern.compile(":|,");

    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    public int calculate(String input) {
        if (isEmpty(input)) {
            return ZERO;
        }
        return sum(stringToInt(split(input)));
    }

    private boolean isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }

    private String[] split(String input) {
        Matcher customDelimiterMatcher = customDelimiterPattern.matcher(input);
        return isCustomDelimiterPattern(customDelimiterMatcher) ? customDelimiterSplit(
            customDelimiterMatcher) : numberPattern.split(input);
    }

    private boolean isCustomDelimiterPattern(Matcher customDelimiterMatcher) {
        if (customDelimiterMatcher.find()) {
            return true;
        }
        return false;
    }

    private String[] customDelimiterSplit(Matcher customDelimiterMatcher) {
        String customDelimiter = customDelimiterMatcher.group(ONE);
        return customDelimiterMatcher.group(TWO).split(customDelimiter);
    }

    private int[] stringToInt(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(str -> {
            try {
                int num = Integer.parseInt(str);
                if (num < 0) {
                    throw new RuntimeException("음수가 포함되어 있습니다: " + num);
                }
                return num;
            } catch (Exception e) {
                throw new RuntimeException("유효하지 않은 숫자가 포함되어 있습니다: " + str, e);
            }
        }).toArray();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
