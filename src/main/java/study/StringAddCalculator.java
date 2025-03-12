package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (isNumber(text)) {
            return Integer.parseInt(text);
        }

        if (text.startsWith("//")) {
            return getCustomDelimiterSum(text);
        }

        return getSplitSum(text);
    }

    static private boolean isNumber(String text) {
        return text.matches("-?\\d+");
    }

    static private int getSplitSum(String text) throws RuntimeException {
        String[] tokens = text.split(",|:");
        return sumStringToken(tokens);
    }

    static private int getCustomDelimiterSum(String text) throws RuntimeException {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return sumStringToken(tokens);
        }

        throw new IllegalArgumentException();
    }

    static private int sumStringToken(String[] tokens) throws RuntimeException {
        int sum = 0;

        for(String token: tokens) {
            sum += getSingleNumber(token);
        }
        return sum;
    }

    static private int getSingleNumber(String text) throws RuntimeException {
        int number = Integer.parseInt(text);
        if (number < 0) {
            throw new RuntimeException("음수가 입력되었습니다." + number);
        }
        return number;
    }
}
