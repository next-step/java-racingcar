package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String data){
       if(data == null || data.isEmpty()) return 0;
        return sum(split(data));
    }

    private static String[] split(String data) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
           return tokens;
        }
        return data.split(",|:");
    }

    private static int sum(String[] tokens){
        int result = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if(num < 0){
                throw new RuntimeException();
            }
            result += num;
        }
        return result;
    }
}
