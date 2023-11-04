package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    static String SPLIT_TEXT = ",|:";

    static int isNullOrBlankToZero = 0;

    static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text){

        int number;

        if (text == null || text.isBlank()) {
            return isNullOrBlankToZero;
        }

        if(text.length() == 1){
           number = oneNumber(text);
           return number;
        }

        number = manyNumber(text);

        return number;
    }

    public static int oneNumber(String text){
        return Integer.parseInt(text);
    }

    public static int manyNumber(String text){

        int number = 0;

        String[] tokens = getStrings(text);

        Matcher m = getMatcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        number = getNumber(tokens);

        return number;
    }

    private static int getNumber(String[] tokens) {
        int number;
        int[] list = getIntArray(tokens);
        number = getSum(list);
        return number;
    }

    private static int[] getIntArray(String[] tokens) {

        int[] intList = new int[tokens.length];
        for(int i=0; i<tokens.length; i++){
            validNumber(tokens, i);
            intList[i] = Integer.parseInt(tokens[i]);
        }

        return intList;
    }

    private static void validNumber(String[] tokens, int i) {
        if(Integer.parseInt(tokens[i]) < 0){
            throw new RuntimeException("음수는 불가능");
        }
    }

    private static int getSum(int[] list) {
        int sum = 0;
        for(int i=0; i<list.length; i++){
            sum += list[i];
        }
        return sum;
    }

    private static String[] getStrings(String text) {
        return text.split(SPLIT_TEXT);
    }

    private static Matcher getMatcher(String text) {
        return pattern.matcher(text);
    }

}
