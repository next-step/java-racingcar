package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text){
        if(isNullOrEmpty(text)){
            return 0;
        }

        return sumAll(splitString(text));
    }

    public static boolean isNullOrEmpty(String text){
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public static String[] splitString(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    public static int sumAll(String[] numbers){
        int result = 0;
        for(String n : numbers){
            validateNonNegative(Integer.valueOf(n));
            result += Integer.valueOf(n);
        }

        return result;
    }

    public static void validateNonNegative(int num){
        if(num < 0) throw new RuntimeException("음수입니다.");
    }


}
