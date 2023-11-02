package calculator;

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
        int[] list = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .filter(num -> {
                    if(num < 0){
                        throw new RuntimeException();
                    }
                    return true;
                })
                .toArray();
        number = Arrays.stream(list).sum();
        return number;
    }

    private static String[] getStrings(String text) {
        String[] tokens= text.split(SPLIT_TEXT);
        return tokens;
    }

    private static Matcher getMatcher(String text) {
        Matcher matcher = pattern.matcher(text);
        return matcher;
    }

}
