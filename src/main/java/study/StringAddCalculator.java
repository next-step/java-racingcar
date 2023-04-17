package study;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT = "0";

    public static int splitAndSum(String text) {
        int[] numbers = {};
        String number = emptyAndNullChk(text);
        nagativeChk(number);

        if (number.contains("//")) {
            return sum(customSepate(number));
        }
        numbers = separate(number);
        return sum(numbers);
    }

    private static String emptyAndNullChk(String text) {
        if (text == null || text.isEmpty()) {
            return DEFAULT;
        }
        return text;
    }

    private static void nagativeChk(String text) {
        if (text.contains("-")) {
            throw new RuntimeException();
        }
    }

    private static int[] separate(String text) {
        String[] numbers = text.split(",|:");
        return numberToInteger(numbers);
    }

    private static int[] customSepate(String text) {
        int[] result = {};
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            result = numberToInteger(tokens);
        }
        return result;
    }

    private static int[] numberToInteger(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static int sum(int[] numbers) {
        int result = 0;
        for (int num: numbers) {
            result += num;
        }
        return result;
    }
}
