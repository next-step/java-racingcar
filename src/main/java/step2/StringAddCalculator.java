package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(isNullOrEmpty(input)) return 0;
        int result = calculate(input);

        return result;
    }

    private static boolean isNullOrEmpty(String input){
        if(input == null || input.isEmpty()){
            return true;
        }
        return false;
    }

    private static String[] parseInput(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            String customSeparator = m.group(1);
            String[] tokens = m.group(2).split(customSeparator);
            return tokens;
        }

        if(!m.find()){
            String[] tokens = input.split(",|:");
            return tokens;
        }

        return new String[]{};
    }

    private static int calculate(String input){
        int result = 0;
        String[] tokens = parseInput(input);
        for(String element : tokens ){
            int number = Integer.parseInt(element);
            if(number < 0) throw new RuntimeException();

            result += number;
        }

        return result;
    }
}

