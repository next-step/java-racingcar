package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static String delimiter = ",|:";
    static String pattern = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isEmpty(text)){
            return 0;
        }
        String[] numbers = split(text);
        return sum(numbers);
    }

    public static boolean isEmpty(String text){
        return text == null || text.isEmpty();
    }

    public static String[] split(String text){
        Matcher m = Pattern.compile(pattern).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(delimiter);
    }

    public static int sum(String[] numbers){
        int result = 0;
        for (String number: numbers) {
            validationCheck(number);
            result += Integer.parseInt(number);
        }
        return result;
    }

    public static void validationCheck(String number){
        if(Integer.parseInt(number) < 0){
            throw new RuntimeException();
        }
    }
}
