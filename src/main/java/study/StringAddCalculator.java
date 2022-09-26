package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String BASE_SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndSum(String target) {
        if (isNullOrEmpty(target)) {
            return 0;
        }

        Matcher m = Pattern.compile(CUSTOM_SEPARATOR).matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return getArraySum(m.group(2).split(customDelimiter));
        }

        return getArraySum(target.split(BASE_SEPARATOR));
    }

    public static boolean isNullOrEmpty(String target) {
        return (null == target || target.trim().isEmpty());
    }

    public static int getArraySum(String[] targetArr) {
        int result = 0;

        for (String s : targetArr) {
            int item = Integer.parseInt(s);
            if (0 > item) {
                throw new RuntimeException("음수는 포함될 수 없습니다.");
            }
            result += item;
        }
        return result;
    }
}
