package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    
    public static final String COMMA_AND_COLONS = ",|:";
    
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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        if(text.contains(",") || text.contains(":")) {
            return text.split(COMMA_AND_COLONS);
        }
        return new String[]{text};
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
