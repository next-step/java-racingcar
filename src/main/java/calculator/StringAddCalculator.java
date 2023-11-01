package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {

    static String SPLIT_TEXT = ",|:";

    public static int splitAndSum(String text){

        int number = 0;

        if (text == null || text.isBlank()) {
            return 0;
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

        String[] tokens= text.split(SPLIT_TEXT);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

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
}
