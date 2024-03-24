package step2_string_add_calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputStr) {
        if (isNullOrEmpty(inputStr)) return 0;
        return Arrays.stream(split(inputStr))
                .mapToInt(StringAddCalculator::parseAndValidate)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(Pattern.quote(customDelimiter));
        }
        return input.split(",|:");
    }

    private static int parseAndValidate(String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 0)
                throw new RuntimeException("음수는 허용되지 않습니다: " + str);
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException("유효하지 않은 숫자입니다: " + str, e);
        }
    }
}