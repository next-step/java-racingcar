package study.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static int splitSum(String text) {

        if(text == null || text.isEmpty()){
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return getSum(tokens);
        }

        String[] numbers = text.split(",|:");

        return getSum(numbers);
    }

    private static int getSum(String[] numbers) {
        int sum = 0;
        for(int i = 0; i< numbers.length; i++){
            int number = getNumber(numbers[i]);
            minusException(number);
            sum += number;
        }
        return sum;
    }

    private static void minusException(int number) {
        if(number <0){
            throw new RuntimeException("");
        }
    }

    private static int getNumber(String numbers) {
        int number = Integer.parseInt(numbers);
        return number;
    }

}
