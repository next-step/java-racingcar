package util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static util.Constants.*;

public class StringAddCalculator {
    public static final int ZERO = 0;
    public static final String DELIMITER_REGEX_BASIC = ",|:";
    public static final Pattern PATTERN_DELIMITER_CUSTOM = Pattern.compile("//(.)\n(.*)");
    public static final int IDX_CUSTOM_DELIMITER = 1;
    public static final int IDX_INPUT_STRING = 2;

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return ZERO;
        }
        return sum(input);
    }

    private static int sum(String input) {
        return Arrays.stream(getValues(input))
                .mapToObj(Number::new)
                .map(Number::getNumber)
                .reduce(Integer::sum).get();
    }

    private static int[] getValues(String input) {
        String[] inputValues = split(input);
        String inputValue;
        int len = inputValues.length;
        int[] values = new int[len];

        for (int i = 0; i < len; i++) {
            inputValue = inputValues[i];
            validateNumber(inputValue);
            values[i] = Integer.parseInt(inputValue);
        }
        return values;
    }

    private static String[] split(String input) {
        Matcher m = PATTERN_DELIMITER_CUSTOM.matcher(input);

        if (m.find()) {
            input = m.group(IDX_INPUT_STRING);
            return input.trim().split(m.group(IDX_CUSTOM_DELIMITER));
        }
        return input.trim().split(DELIMITER_REGEX_BASIC);
    }

    private static void validateNumber(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException(ERROR_MESSAGE_INPUT_NOT_INTEGER);
        }
    }
}
