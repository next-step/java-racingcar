package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

     public static int splitAndSum(String text){
         if(isBlank(text)) {
             return 0;
         }

         Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
         if(m.find()){
             String customDelimiter = m.group(1);
             ArrayList<String> tokens = new ArrayList<>();
             tokens = split(m.group(2), customDelimiter, tokens);

             return sum(toInts(tokens));
         }
         ArrayList<String> values = new ArrayList<>();
         values = split(text, DEFAULT_DELIMITER, values);
         return sum(toInts(values));

     }

    private static ArrayList<String> split(String text, String defaultDelimiter, ArrayList<String> values) {
        for(String value : text.split(defaultDelimiter)){
            values.add(value);
        }
        return values;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(ArrayList<Integer> numbers){
         int sum = 0;
         for (int number : numbers) {
             sum += number;
         }
         return sum;
     }

     private static ArrayList<Integer> toInts(ArrayList<String> values){
         ArrayList<Integer> numbers = new ArrayList<>();
         for(String value : values){
             numbers.add(toInt(value));
         }
         return numbers;
     }

     private static int toInt(String value){
         int number = Integer.parseInt(value);
         if(number < 0){
             throw new RuntimeException("음수 허용X");
         }
         return number;
     }
}
