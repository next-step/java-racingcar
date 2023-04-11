package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final int  ZERO = 0;
    public static int splitAndSum(String text){
        if(isBlank(text)){
            return ZERO;
        }
        return sum(toInts(split(customDelimiter(text))));
    }

    private static String[] split(String text){
        return text.split(",|:");
    }

    private static String customDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            text = m.group(2).replace(customDelimiter,":");
        }
        return text;
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(int[] numbers){
        int sum = ZERO;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i=0 ; i< values.length ; i++){
            int number = toInt(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int toInt(String value) {
        if(false == value.matches("[0-9]+")){
            throw new RuntimeException("숫자만 입력할 수 있습니다.");
        }
        int number = Integer.parseInt(value);
        if(number < 0){
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
        return number;
    }
}
