package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    static int splitAndSum(String text){
        int sum = 0;
        if (text==null || text.isEmpty()){
            return 0;
        }
        if (text.length()==1){
            int number = Integer.parseInt(text);
            return number;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()){
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            sum = sumAll(tokens);
            if(sum > 0) return sum;

        }
        else{
            String[] numbers = text.split(",|:");
            sum = sumAll(numbers);

            if(sum > 0) return sum;
        }

        return -1;
    }
    public static int sumAll (String[] s){
        int total=0;
        for(String i : s){
            int num = Integer.parseInt(i);
            if (num<0){
                throw new RuntimeException();
            }
            total += num;
        }
        return total;

    }
}
