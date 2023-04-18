package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator{

    public static final int ZERO = 0;
    public static final String DELIMITERS = ",|:";

    public static int nullEmptyReturnZero(String text){
        if(isBlank(text)){return ZERO;}
        return -1;
    }

    public static int stringSum(String text){
        return sum(toInts(split(text)));
    }

    private static int sum(int[] numbers) {
        int sum = ZERO;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    private static String[] split(String text) {
        Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");
        Matcher matchText = customDelimiterPattern.matcher(text);

        if(matchText.find()){
            return matchText.group(2).split(matchText.group(1));
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
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }
}