package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static Pattern custom = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {
        throw new AssertionError();
    };

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = custom.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return addEachItem(tokens);
        }

        return addEachItem(text.split( ",|:"));
    }

    private static int addEachItem(String[] numbers) {
        int result = 0;
        for(String num:numbers) {
            int temp = getIfNumber(num);
            checkPositive(temp);
            result += temp;
        }
        return result;
    }

    private static int getIfNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch(NumberFormatException e){
            return -1;
        }
    }

    private static void checkPositive(int number) {
        if(number < 0){
            throw new RuntimeException();
        }
    }
}
