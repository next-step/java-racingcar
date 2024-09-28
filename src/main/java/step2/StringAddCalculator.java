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
        String[] values = splitString(inputValue);
        int sum = 0;
        for (String value : values) {
            sum += Integer.parseInt(value);
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
}
