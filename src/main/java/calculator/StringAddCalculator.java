package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int add(String text) {
        if(isEmpty(text)) return 0;

        String[] numbers = split(text);
        return getSum(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        String splitSeparator = ",|:";

        if(matcher.find()) {
            splitSeparator = matcher.group(1);
            text = matcher.group(2);
        }

        return text.split(splitSeparator);
    }

    private static int getSum(String[] numbers) {
        int sum = 0;

        for(String number : numbers) {
            sum += getPositiveNumber(number);
        }

        return sum;
    }

    private static int getPositiveNumber(String number) {
        int result = Integer.parseInt(number);
        if(result < 0)
            throw new RuntimeException();

        return result;

    }
}