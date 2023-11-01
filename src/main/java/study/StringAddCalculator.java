package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] tokens = parseText(text);

        return sum(tokens);
    }

    private static String[] parseText(String text) {
        String seperator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            seperator = m.group(1);
            text = m.group(2);
        }
        return text.split(seperator);
    }

    private static int sum(String[] tokens) {
        int result = 0;
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
