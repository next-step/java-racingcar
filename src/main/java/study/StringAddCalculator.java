package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int result = 0;
        if(text == null || text.isEmpty()) {
            return result;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        if (text.contains(",") || (text.contains(":"))) {
            String[] split = text.split(",|:");
            for (String s : split) {
                int anInt = Integer.parseInt(s);
                if (anInt < 0) {
                    throw new RuntimeException();
                }
                result += anInt;
            }
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            for (String token : tokens) {
                int anInt = Integer.parseInt(token);
                if (anInt < 0) {
                    throw new RuntimeException();
                }
                result += anInt;
            }
        }
        return result;
    }

}
