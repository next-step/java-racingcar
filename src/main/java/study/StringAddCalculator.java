package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text){

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] numbers = {};
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        } else {
            numbers = text.split(",|:");
        }

        int result = 0;
        for(String n : numbers){
            if(Integer.valueOf(n) < 0) {
                throw new RuntimeException();
            }
            result += Integer.valueOf(n);
        }

        return result;
    }

}
