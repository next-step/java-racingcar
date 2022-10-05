package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String BASE_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    private static final String ONLY_NUMBER_REGEXP = "^(-?)[0-9]+$";

    private StringAddCalculator() {}

    public static int splitAndSum(String target) {
        if (isNullOrEmpty(target)) {
            return 0;
        }

        Matcher customSeparatorMatcher = CUSTOM_SEPARATOR_PATTERN.matcher(target);

        if (customSeparatorMatcher.find()) {
            String customDelimiter = customSeparatorMatcher.group(1);
            return getArraySum(customSeparatorMatcher.group(2).split(customDelimiter));
        }

        return getArraySum(target.split(BASE_SEPARATOR));
    }

    public static boolean isNullOrEmpty(String target) {
        return (null == target || target.trim().isEmpty());
    }

    public static int getArraySum(String[] targetArr) {
        int result = 0;

        for (String s : targetArr) {
            if (!s.matches(ONLY_NUMBER_REGEXP)) {
                throw new RuntimeException("숫자가 아닌 값은 포함될 수 없습니다.");
            }

            int item = Integer.parseInt(s);
            if (0 > item) {
                throw new RuntimeException("음수는 포함될 수 없습니다.");
            }
            result += item;
        }
        return result;
    }
}
