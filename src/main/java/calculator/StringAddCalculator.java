package calculator;

import calculator.utils.validator.InputValidator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMETER_REGEX = ",|:";
    private static final String CUSTOM_DELIMETER_REGEX = "//(.)\n(.*)";

    private static final int CUSTOM_DELIMETER = 1;
    private static final int CUSTOM_PATTERN_NUMBERS = 2;


    private static final Pattern customDelimeterPattern = Pattern.compile(CUSTOM_DELIMETER_REGEX);

    private static StringAddCalculator instance;

    private StringAddCalculator() {}

    public static StringAddCalculator getInstance() {
        if (instance == null) {
            return new StringAddCalculator();
        }
        return instance;
    }

    public int splitAndSum(String text) {
        if (!InputValidator.validateUserInput(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private int sum(int[] numbers) {
        int ret = 0;
        for (int number : numbers) {
            ret += number;
        }
        return ret;
    }

    private int toInt(String num) {
        InputValidator.isValidNumber(num);
        int ret = Integer.parseInt(num);
        return ret;
    }

    private int[] toInts(String[] numbers) {
        int[] ret = new int[numbers.length];
        for (int i = 0 ; i < numbers.length ; i++) {
            ret[i] = toInt(numbers[i]);
        }
        return ret;
    }

    private int[] split(String text) {
        Matcher customPatternMatcher = customDelimeterPattern.matcher(text);
        if (customPatternMatcher.matches()) {
            String customDelimiter = customPatternMatcher.group(CUSTOM_DELIMETER);
            return toInts(customPatternMatcher.group(CUSTOM_PATTERN_NUMBERS).split(customDelimiter));
        }
        return toInts(text.split(DEFAULT_DELIMETER_REGEX));
    }
}
