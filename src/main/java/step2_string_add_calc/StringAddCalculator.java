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
            return calculate(m.group(1), m.group(2));
        }
        return calculate("[,:]", inputStr);
    }

    private static int calculate(String delimiter, String inputStr) {
        return Arrays.stream(inputStr.split(delimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}