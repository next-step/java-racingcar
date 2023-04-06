package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String DEFAULT = "0";

    static String emptyAndNullChk(String text) {
        if (text == null) {
            return DEFAULT;
        }
        if (text.isEmpty()) {
            return DEFAULT;
        }
        return text;
    }

    static int numberToInteger(String text) {
        return Integer.parseInt(text);
    }

    static String[] separate (String text) {
        String[] numbers = text.split(",|:");
        return numbers;
    }

    static int sum (String[] numbers) {
        int result = 0;
        for (String num: numbers) {
            result += numberToInteger(num);
        }
        return result;
    }


    static int splitAndSum(String text) {
        String number = emptyAndNullChk(text);

        if (number.contains("-")) {
            throw new RuntimeException();
        }

        String[] numbers = separate(number);

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(number);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sum(tokens);
        }

        return sum(numbers);
    }
}
