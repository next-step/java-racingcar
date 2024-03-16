package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(isNullOrEmpty(input)) return 0;
        String[] tokens = tokenize(input);
        int result = calculate(tokens);

        return result;
    }

    private static boolean isNullOrEmpty(String input){
        if(input == null || input.isEmpty()){
            return true;
        }
        return false;
    }

    private static String[] tokenize(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            String customSeparator = m.group(1);
            return m.group(2).split(customSeparator);
        }

        return input.split(",|:");
    }

    private static int calculate(String[] tokens){
        int result = 0;

        for(String token : tokens){
            int number = Integer.parseInt(token);
            if(number < 0) throw new RuntimeException();
            result += number;
        }

        return result;
    }
}

