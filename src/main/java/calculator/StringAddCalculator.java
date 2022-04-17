package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static String DEFAULT_DELIMITER = ",|:";
    static String CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;

        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            input = matcher.group(2);
        }

        int sum = sum(input.split(delimiter));
        return sum;
    }

    private static int sum(String[] strings) {
        int result = 0;
        for (String string : strings) {
            result += parseInt(string);
        }
        return result;
    }

    private static int parseInt(String value) {
        Integer num = Integer.parseInt(value);
        if (num < 0) {
            throw new RuntimeException("음수 문자열은 허용되지 않습니다.");
        }
        return num;
    }
}
