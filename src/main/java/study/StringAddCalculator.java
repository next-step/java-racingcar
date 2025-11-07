package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    public static final String COMMA_AND_COLON_REGEX = ",|:";
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    
    public static int splitAndSum(String text) {
        return isNullOrEmpty(text) ? 0 : adder(stringsToInts(splitText(text)));
    }
    
    private static int adder(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result += num;
        }
        return result;
    }
    
    private static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(text);
        return m.find() ? m.group(2).split(m.group(1)) : text.split(COMMA_AND_COLON_REGEX);
    }
    
    private static int[] stringsToInts(String[] texts) {
        int length = texts.length;
        int[] ints = new int[length];
        for(int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(texts[i]);
        }
        return ints;
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
