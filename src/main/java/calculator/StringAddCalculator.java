package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(isNotEmptyValue(text)) {
            return getSumByStringNumbers(findTextDelimiter(text));
        }
        return 0;
     }

    private static boolean isNotEmptyValue(String text) {
        return text != "" && text != null;
    }

    private static String[] findTextDelimiter(String text) {
        String[] numbers;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        }else{
            numbers = text.split(",|:");
        }
        return numbers;
    }

    private static int getSumByStringNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += getRuntimeExceptionByNegativeNumber(Integer.parseInt(number));
        }
        return sum;
    }

    private static int getRuntimeExceptionByNegativeNumber(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
        return number;
    }
}