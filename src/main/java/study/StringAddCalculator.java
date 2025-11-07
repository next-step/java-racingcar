package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final String NORMAL_REGEX = ",|:";
    
    public static int splitAndSum(String text) {
        int result = 0;
        for (String s : splitText(defaultIfEmpty(text))) {
            result += parseToInt(s);
        }
        return result;
    }

    private static String defaultIfEmpty(String text) {
        return (text == null || text.isEmpty()) ? "0" : text;
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(NORMAL_REGEX);
    }

    private static int parseToInt(String token) {
        int anInt = Integer.parseInt(token);
        if (anInt < 0) {
            throw new RuntimeException("음수가 나오면 안됩니다.");
        }
        return anInt;
    }
}
