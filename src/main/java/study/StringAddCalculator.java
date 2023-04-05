package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    //TODO: 메소드가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
    public static int splitAndSum(String givenValue) {
        if (givenValue == null || givenValue.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(givenValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            System.out.println("customDelimiter = " + customDelimiter);
            String[] tokens = m.group(2).split(customDelimiter);
            int total = 0;
            for (String number : tokens) {
                total += Integer.parseInt(number);
            }
            return total;
        }
        String[] numbers = givenValue.split(",|:");
        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }
        int total = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                throw new RuntimeException();
            }
            total += parsedNumber;
        }
        return total;

    }

}
