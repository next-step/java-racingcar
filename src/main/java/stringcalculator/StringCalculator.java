package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public static int[] toIntArray(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
    }

    public static ParseInfo separateCustomText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        m.find();
        String delimiter = m.group(1);
        String input = m.group(2);
        return new ParseInfo(delimiter, input);
    }

    public static boolean isValidArray(String[] stringArray) {
        for (String s : stringArray) {
            if (!s.matches("^[0-9]+$")) {
                throw new RuntimeException("유효하지 않은 값입니다");
            }
        }
        return true;
    }
}
