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
            String[] split = matcher.group(2).split(customDelimiter);
            return sum(split);
        }
        String[] split = split(text);
        return sum(split);
    }

    public static String[] split(String text){
        return text.split(",|:");
    }

    public static int sum(String[] textArray){
        int result = 0;
        for (String text : textArray) {
            result += Integer.parseInt(text);
        }
        return result;
    }
}
