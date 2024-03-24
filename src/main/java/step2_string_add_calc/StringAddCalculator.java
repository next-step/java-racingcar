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
            String customDelimiter = m.group(1);
            return Arrays.stream(m.group(2).split(customDelimiter))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        return Arrays.stream(inputStr.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}