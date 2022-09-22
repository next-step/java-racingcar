package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(final String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }
        String[] tokens = split(text);
        return sum(tokens);
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(final String text){
        String delimiter = delimiter(text);
        String convertedText = convertText(text);
        return convertedText.split(delimiter);
    }

    private static int sum(final String[] token){
        int result = 0;
        for (String text : token) {
            int number = parsePositiveNumber(text);
            result += number;
        }
        return result;
    }

    private static String delimiter(final String text){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()){
            return matcher.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String convertText(final String text){
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if(matcher.find()){
            return matcher.group(2);
        }
        return text;
    }

    private static int parsePositiveNumber(final String text) {
        int number = Integer.parseInt(text);
        if(number<0){
            throw new RuntimeException();
        }
        return number;
    }
}
