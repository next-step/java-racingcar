package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String separator = ",|:";
    public static String delimiter = "//(.)\n(.*)";
    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return 0;
        }
        return sum(split(str));
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile(delimiter).matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(separator);
    }

    private static int sum(String[] str) {
        return Arrays.stream(str)
                .mapToInt(StringAddCalculator::toInt)
                .sum();
    }

    private static int toInt(String str) {
        return Integer.parseInt(str);
    }

    private static boolean isBlank(String str) {
        return str == null || str == "";
    }
}
