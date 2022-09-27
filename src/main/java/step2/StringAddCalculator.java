package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {

        if(checkNullOrEmpty(text)){
            return 0;
        }
        int result = calculator(text);
        return result;

    }

    private static boolean checkNullOrEmpty(String text) {
        if(text == null) { return true;}
        if(text.isEmpty()) { return true;}
        return false;
    }

    private static int calculator(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sumTokens(tokens);
        }
        String[] tokens= text.split(",|:");
        return sumTokens(tokens);
    }

    private  static int sumTokens(String[] tokens) {
        int sum = 0;

        for(String token:tokens) {
            int number = parseInt(token);
            if (number < 0) {
                throw new RuntimeException("음수값이 포함되어 있습니다!");
            }
            sum += number;
        }
        return sum;
    }

    private static int parseInt(String text) {
        return Integer.parseInt(text);
    }




}
