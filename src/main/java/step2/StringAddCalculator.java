package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if (input == null || input.isEmpty()) return result;

        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            String customSplitDelimiter = m.group(1);
            tokens = m.group(2).split(customSplitDelimiter);
        } else {
            tokens = input.split("[,:]");
        }

        for(String token : tokens){
            int number = Integer.parseInt(token);
            if(number < 0) throw new RuntimeException();
            result += number;
        }

        return result;
    }
}
