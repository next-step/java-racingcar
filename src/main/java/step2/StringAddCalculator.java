package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator{

    public static final int ZERO = 0;
    public static final String DELIMITERS = ",|:";

    public static int splitAndSum(String text){
        //빈문자열 또는 null을 입력한 경우
        if(isBlank(text)){return ZERO;}

        return sum(toInts(split(text)));

        /*if(text.length() > 1) {
            //구분자를 컴마(,) 이외에 콜론(:)을 사용한 경우
            if(text.contains(":")){
                String[] tokens = text.split(":|,");
                int result = 0;
                for(int i=0; i < tokens.length; i++) {
                    result += Integer.parseInt(tokens[i]);
                }
                return result;
            }
            //숫자 두개를 컴마(,) 구분자로 입력한 경우
            if(text.contains(",")){
                String[] numbers = text.split(",");
                return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            }
        }
        */
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            return m.group(2).split(m.group(1));
        }
        return text.split(DELIMITERS);
    }

    private static int[] toInts(String[] texts) {
        int[] numbers = new int[texts.length];
        for(int i=0; i < texts.length; i++){
            numbers[i] = Integer.parseInt(texts[i]);
            negativeCheck(numbers[i]);
        }
        return numbers;
    }

    private static void negativeCheck(int numbers){
        if(numbers < 0){
            throw new RuntimeException();
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}
