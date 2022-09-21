package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        String[] tokens = tokens(text);
        return sum(tokens);
    }

    private static String[] tokens(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return split(text);
    }

    public static String[] split(String text){
        return text.split(DEFAULT_DELIMITER);
    }

    public static int sum(String[] token){
        int result = 0;
        for (String text : token) {
            int number = parsePositiveNumber(text);
            result += number;
        }
        return result;
    }

    private static int parsePositiveNumber(String text) {
        int number = Integer.parseInt(text);
        if(number<0){
            throw new RuntimeException();
        }
        return number;
    }
}
