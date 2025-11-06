package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(Pattern.quote(customDelimiter));
            return Arrays.stream(tokens).mapToInt(Integer::parseInt).sum();
        }
        String[] result = input.split(",|:");
        return Arrays.stream(result).mapToInt(Integer::parseInt).sum();
    }
}
