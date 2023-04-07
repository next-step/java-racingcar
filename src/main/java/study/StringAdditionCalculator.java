package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_INPUT_PATTERN_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_BEGIN_INDEX = 2;
    private static final int CUSTOM_DELIMITER_END_INDEX = 3;
    private static final int CUSTOM_DELIMITER_SEPARATED_OPERANDS_BEGIN_INDEX = 4;

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
            return 0;
        }

        int[] positiveOperands = separatedOperandsOf(input).getPositiveOperands();
        return sumOf(positiveOperands);
    }

    private static SeparatedOperands separatedOperandsOf(String input) {
        if(isCustomDelimiterInput(input)) {
            return new SeparatedOperands(customDelimiterOf(input), customSeparatedStringOf(input));
        }

        return new SeparatedOperands(DEFAULT_DELIMITER_REGEX, input);
    }

    private static String customSeparatedStringOf(String input) {
        return input.substring(CUSTOM_DELIMITER_SEPARATED_OPERANDS_BEGIN_INDEX);
    }

    private static String customDelimiterOf(String input) {
        return input.substring(CUSTOM_DELIMITER_BEGIN_INDEX, CUSTOM_DELIMITER_END_INDEX);
    }

    private static boolean isCustomDelimiterInput(String input) {
        return matcherOf(input).matches();
    }

    private static Matcher matcherOf(String input) {
        return Pattern.compile(CUSTOM_DELIMITER_INPUT_PATTERN_REGEX).matcher(input);
    }

    private static int sumOf(int[] operands) {
        return Arrays.stream(operands).sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
