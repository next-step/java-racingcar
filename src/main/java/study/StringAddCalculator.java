package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public static int add(String s) {

        int sum = 0;

        if(s == null || s.equals("")){
            return 0;
        }
        String[] numbers = s.split(",|:");
        Matcher matcher = Pattern.compile("(\\/\\/)(.*)(\\n)(.*)").matcher(s);
        if(matcher.find()) {
            String customDelimiter = matcher.group(2);
            numbers =matcher.group(4).split(customDelimiter);
        }

        for(int i = 0; i < numbers.length; i++) {
         if(Integer.parseInt(numbers[i]) < 0){
             throw new RuntimeException("minus input error !!");
         }
          sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
