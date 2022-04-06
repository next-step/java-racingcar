package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String DEFAULT_REGEX = ",|:";
    public static final int DEFAULT_SUM = 0;

    public static int splitAndSum(String string) throws RuntimeException {
        if (string == null || string.isEmpty()) {
            return DEFAULT_SUM;
        }

        PositiveNumbers splitTokens = new PositiveNumbers(getSplitTokens(string));

        return splitTokens.sum();
    }

    private static String[] getSplitTokens(String string) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(string);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }

        return string.split(DEFAULT_REGEX);
    }

}
