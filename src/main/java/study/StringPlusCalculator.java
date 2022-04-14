package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    private StringPlusCalculator() {
    }

    public static int sumOfNumbers(String s) {
        if (isEmptyOrNull(s)) {
            return 0;
        }
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(s);
        if (matcher.find()) {
            return sum(split(matcher.group(2), matcher.group(1)));
        }
        return sum(split(s, DEFAULT_DELIMITER));
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String s : values) {
            if (isNonNegativeInteger(s)) {
                result += Integer.parseInt(s);
            }
        }
        return result;
    }

    private static boolean isNonNegativeInteger(String s) {
        if (s.matches("[+]?\\d*(\\.\\d+)?")) {
            return true;
        }
        throw new RuntimeException("음수가 포함되어 있습니다.");
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static boolean isEmptyOrNull(String s) {
        return s == null || s.isEmpty();
    }
}
