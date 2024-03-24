package step2_string_add_calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputStr) {
        if (isNullOrEmpty(inputStr))
            return 0;
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(inputStr);
        if (m.find()) {
            return calcWithDelimiter(m.group(1), m.group(2));
        }
        return calcWithDelimiter("[,:]", inputStr);
    }
    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static int calcWithDelimiter(String delimiter, String inputStr) {
        return Arrays.stream(inputStr.split(delimiter))
                .mapToInt(StringAddCalculator::parseAndValidate)
                .sum();
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