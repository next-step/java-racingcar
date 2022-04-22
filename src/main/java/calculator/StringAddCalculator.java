package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";
    public static final int BLANK_RESULT = 0;
    public static final int LIMIT_CRITERIA = 0;

     public static int splitAndSum(String text){

         if(isBlank(text)) {
             return BLANK_RESULT;
         }

         Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
         if(matcher.find()){
             String customDelimiter = matcher.group(1);
             List<String> tokens = new ArrayList<>();
             tokens = split(matcher.group(2), customDelimiter);

             return sum(toInts(tokens));
         }
         List<String> values = new ArrayList<>();
         values = split(text, DEFAULT_DELIMITER);
         return sum(toInts(values));

     }

    private static List<String> split(String text, String defaultDelimiter) {
         List<String> values = new ArrayList<>();
        for(String value : text.split(defaultDelimiter)){
            values.add(value);
        }
        return values;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(List<Integer> numbers){
         int sum = 0;
         for (int number : numbers) {
             sum += number;
         }
         return sum;
     }

     private static List<Integer> toInts(List<String> values){
         List<Integer> numbers = new ArrayList<>();
         for(String value : values){
             numbers.add(toInt(value));
         }
         return numbers;
     }

     private static int toInt(String value){
         int number = Integer.parseInt(value);
         if(number < LIMIT_CRITERIA){
             throw new RuntimeException("음수는 허용하지 않습니다.");
         }
         return number;
     }
}
