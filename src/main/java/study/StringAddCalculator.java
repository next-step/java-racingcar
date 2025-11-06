package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        int result = 0;
        for (String s : splitText(isExist(text))) {
            result += parseToInt(s);
        }
        return result;
    }

    private static String isExist(String text) {
        return (text == null || text.isEmpty()) == true ? "0" : text;
    }

    private static String[] splitText(String text) {
        if (text.contains(",") || (text.contains(":"))) {
            return text.split(",|:");
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return new String[]{text};
    }

    private static int parseToInt(String token) {
        int anInt = Integer.parseInt(token);
        if (anInt < 0) {
            throw new RuntimeException();
        }
        return anInt;
    }
}
