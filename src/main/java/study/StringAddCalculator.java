package study;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        var matcher = pattern.matcher(value);

        if (matcher.find()) {
            var customSpliter = matcher.group(1);
            var tokens = matcher.group(2).split(customSpliter);

            return Arrays.stream(tokens)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }

        return Arrays.stream(value.split("[,:]"))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
