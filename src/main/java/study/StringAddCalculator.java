package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SPLITER = "[,:]";

    public static int splitAndSum(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        var spliter = getSpliter(value);
        var toBeSplitValue = getToBeSplitValue(value);

        var tokens = toBeSplitValue.split(spliter);

        if (hasNegativeNumber(tokens)) {
            throw new RuntimeException();
        }

        return Arrays.stream(tokens)
                     .mapToInt(Integer::parseInt)
                     .sum();
    }

    private static boolean hasCustomSpliter(Matcher matcher) {
        return matcher.find();
    }

    private static String getSpliter(String value) {
        var matcher = pattern.matcher(value);
        return hasCustomSpliter(matcher) ? matcher.group(1) : DEFAULT_SPLITER;
    }

    private static String getToBeSplitValue(String value) {
        var matcher = pattern.matcher(value);
        return hasCustomSpliter(matcher) ? matcher.group(2) : value;
    }

    private static boolean hasNegativeNumber(String[] values) {
        return Arrays.stream(values)
                     .mapToInt(Integer::parseInt)
                     .anyMatch(num -> num < 0);
    }
}
