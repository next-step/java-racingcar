package step2_string_add_calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String inputStr) {
        if (inputStr == null || inputStr.isEmpty())
            return 0;
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)")
                .matcher(inputStr);
        if (m.find()) {
            return splitAndSum(m.group(1), m.group(2));
        }
        return splitAndSum("[,:]", inputStr);
    }

    private static int splitAndSum(String delimiter, String inputStr) {
        return Arrays.stream(inputStr.split(delimiter))
                .mapToInt(StringAddCalculator::parseAndValidate)
                .sum();
    }
    private static int parseAndValidate(String str) {
        int num = Integer.parseInt(str);
        if (num < 0) {
            throw new RuntimeException("음수는 허용되지 않습니다.");
        }
        return num;
    }
}