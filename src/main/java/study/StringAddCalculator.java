package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static String SEPARATOR = ",|:";
    public static String DELIMITER = "//(.)\n(.*)";
    public static int splitAndSum(String str) {
        if (isBlank(str)) {
            return 0;
        }
        return sum(split(str));
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile(DELIMITER).matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return str.split(SEPARATOR);
    }

    private static int sum(String[] str) {
        return Arrays.stream(str)
                .mapToInt(StringAddCalculator::toInt)
                .sum();
    }

    private static int toInt(String str) {
        if (!isNumeric(str)) {
            throw new IllegalArgumentException("음수는 들어가면 안돼요 --> " + str);
        }
        return Integer.parseInt(str);
    }

    private static boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    private static boolean isBlank(String str) {
        return str == null || str == "";
    }
}
