package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return sum(tokens);
        }
        String[] tokens = split(text);
        return sum(tokens);
    }

    public static String[] split(String text){
        return text.split(",|:");
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
