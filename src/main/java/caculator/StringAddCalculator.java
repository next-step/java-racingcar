package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int result = 0;

        if(isNull(input) || input.isEmpty()) {
           return result;
        }

        String[] numbers;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers= m.group(2).split(customDelimiter);
        }else{
            numbers = input.split(",|:");
        }

        for(int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);

            if(number < 0) {
                throw new RuntimeException();
            }

            result += number;
        }

        return result;
    }
}
