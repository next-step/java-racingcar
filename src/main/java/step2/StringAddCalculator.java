package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        boolean checkValidNum = validNum(text);
        if (!checkValidNum) {
            return 0;
        }
        String[] numbers = splitNum(text);
        int sum = sumNum(numbers);
        return sum;
    }

    public static boolean validNum(String text) {
        if (text == null) {
            return false;
        }
        if (text.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String[] splitNum(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    public static int sumNum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
