package study;

import java.util.Arrays;

public class StringAddCalculator {
    public static String separator = ",";
    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return 0;
        }
        return sum(split(str));
    }

    private static String[] split(String str) {
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
