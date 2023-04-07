package util;


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String DELIMITER_REGEX_BASIC = ",|:";
    public static final String DELIMITER_REGEX_CUSTOM = "//(.)\n(.*)";
    public static final int IDX_CUSTOM_DELIMITER = 1;
    public static final int IDX_INPUT_STRING = 2;

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return ZERO;
        }
        return sum(input);
    }

    private static int sum(String input) {
        int result = ZERO;

        for (int val: getValues(input)) {
            Value value = new Value(val);
            result += value.getValue();
        }
        return result;
    }

    private static int[] getValues(String input) {
        String[] inputValues = split(input);
        int len = inputValues.length;
        int[] values = new int[len];

        for (int i = 0; i < len; i++) {
            values[i] = Integer.parseInt(inputValues[i]);
        }
        return values;
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile(DELIMITER_REGEX_CUSTOM).matcher(input);

        if (m.find()) {
            input = m.group(IDX_INPUT_STRING);
            return input.trim().split(m.group(IDX_CUSTOM_DELIMITER));
        }
        return input.trim().split(DELIMITER_REGEX_BASIC);
    }
}
