package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int result = 0;

        if (text == null || text.isEmpty()) {
            return result;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(",|:");
        }

        for (String token : tokens) {
            int value = Integer.parseInt(token);
            if (value < 0) {
                throw new RuntimeException();
            }
            result += value;
        }

        return result;
    }

}
