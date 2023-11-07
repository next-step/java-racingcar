package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.ObjectUtils.isEmpty;

public class StringSpliter {
    private static final String DEFAULT_DELIMITER = ",:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.*?)\\n(.*?)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public static String[] getSplittedString(String input, String delimiter) {
        return input.split("[" + delimiter + "]");
    }

    public static String[] getSplittedString(String input) {
        String customDelimiter = existsCustomDelimiter(input);

        if (isEmpty(customDelimiter)) {
            return getSplittedString(input, DEFAULT_DELIMITER);
        }

        String numberArea = getNumberAreaFromInput(input);
        return getSplittedString(numberArea, customDelimiter);
    }

    public static int[] getIntArray(String[] values) {
        int[] ints = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (!isEmpty(values[i]) && isNegative(values[i])) {
                throw new NumberFormatException("음수는 입력할 수 없습니다.");
            }
            ints[i] = isEmpty(values[i]) ? 0 : Integer.parseInt(values[i]);
        }
        return ints;
    }

    private static Matcher getMatcher(String input) {
        return CUSTOM_PATTERN.matcher(input);
    }

    private static String existsCustomDelimiter(String input) {
        Matcher matcher = getMatcher(input);
        return matcher.find() ? matcher.group(1) : "";
    }

    private static String getNumberAreaFromInput(String input) {
        Matcher matcher = getMatcher(input);
        return matcher.find() ? input.substring(matcher.group(0).length()) : "";
    }

    private static boolean isNegative(String values) {
        return Integer.parseInt(values) < 0;
    }
}
