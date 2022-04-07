package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

     public static int splitAndSum(String text){
         if(isaBlank(text)) {
             return 0;
         }

         Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
         if(m.find()){
             String customDelimiter = m.group(1);
             String[] tokens= m.group(2).split(customDelimiter);

             return sum(toInts(tokens));
         }

         String[] values = split(text, DEFAULT_DELIMITER);
         return sum(toInts(values));

     }

    private static String[] split(String text, String defaultDelimiter) {
        return text.split(defaultDelimiter);
    }

    private static boolean isaBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers){
         int sum = 0;
         for (int number : numbers) {
             sum += number;
         }
         return sum;
     }

     private static int[] toInts(String[] values){
         int[] numbers = new int[values.length];
         for( int i = 0; i < values.length; i++){
             numbers[i] = toInt(values[i]);
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
