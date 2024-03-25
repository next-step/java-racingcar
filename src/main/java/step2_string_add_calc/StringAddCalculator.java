package step2_string_add_calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String inputStr) {
        if (isNullOrEmpty(inputStr)) return 0;
        return Arrays.stream(split(inputStr))
                .mapToInt(StringAddCalculator::parseAndValidate)
                .sum();
    }

    private static boolean isNullOrEmpty(String inputStr) {
        return inputStr == null || inputStr.isEmpty();
    }

    private static String[] split(String inputStr) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputStr);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(Pattern.quote(customDelimiter));
        }
        return inputStr.split("[,:]");
    }

    private static int parseAndValidate(String inputStr) {
        try {
            int num = Integer.parseInt(inputStr);
            if (num < 0)
                throw new RuntimeException("음수는 허용되지 않습니다: " + inputStr);
            return num;
        } catch (NumberFormatException e) {
            throw new RuntimeException("유효하지 않은 숫자입니다: " + inputStr, e);
        }
    }
}