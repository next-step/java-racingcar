package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELEMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int TARGET_STRING_INDEX = 2;
    private static final int MIN_NUMBER = 0;

    public static int splitAndSum(final String inputValue) {
        if (isBlank(inputValue)) {
            return 0;
        }

        return sum(inputValue);
    }

    private static boolean isBlank(final String inputValue) {
        return inputValue == null || inputValue.isEmpty();
    }

    private static int sum(final String inputValue) {
        int[] values = toIntArray(inputValue);
        int sum = 0;
        for (int value : values) {
            validateInputValue(value);
            sum += value;
        }
        return sum;
    }

    private static String[] splitString(final String inputValue) {
        Matcher m = CUSTOM_DELEMITER_PATTERN.matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_INDEX);
            return m.group(TARGET_STRING_INDEX).split(customDelimiter);
        }
        return inputValue.split(DELIMITER);
    }

    private static void validateInputValue(final int value) {
        if (value < MIN_NUMBER) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    private static int[] toIntArray(final String inputValue) {
        String[] values = splitString(inputValue);
        int[] result = new int[values.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(values[i]);
        }

        return result;
    }
}
