package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String FIND_CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    public static final String SPLIT_REGEX = "[,:%s]";

    public static int splitAndSum(String str) {
        if (isNullOrBlank(str)) {
            return 0;
        }

        return Arrays.stream(split(str))
                .mapToInt(StringAddCalculator::toInt)
                .sum();
    }

    private static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    private static String[] split(String str) {
        Matcher m = Pattern.compile(FIND_CUSTOM_DELIMITER_REGEX).matcher(str);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            str = m.group(2);
        }

        return str.split(String.format(SPLIT_REGEX, customDelimiter));
    }

    private static int toInt(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }

        checkNegativeNumber(number);

        return number;
    }

    private static void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

}
