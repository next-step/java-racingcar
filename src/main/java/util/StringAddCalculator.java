package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String PATTERN_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = splitByCustomOrDefaultDelimiter(text);
        return sum(tokens);
    }

    private static String[] splitByCustomOrDefaultDelimiter(String text) {
        Matcher matcher = Pattern.compile(PATTERN_REGEXP).matcher(text);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] tokens) {
        int result = 0;
        for(String token : tokens){
            result += convertToInt(token);
        }

        return result;
    }

    private static int convertToInt(String value) {
        int result = Integer.parseInt(value);
        if(result < 0) {
            throw new IllegalArgumentException();
        }

        return result;
    }
}
