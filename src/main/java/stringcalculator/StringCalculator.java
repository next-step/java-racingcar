package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int sum(int[] nums) {
        return Arrays.stream(nums).sum();
    }

    public static int[] toIntArray(ParseInfo parseInfo) {
        String[] strArray = parseInfo.parse();

        return Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
    }

    public static ParseInfo separateCustomText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        m.find();
        String delimiter = m.group(1);
        String input = m.group(2);
        return new ParseInfo(delimiter, input);
    }
}
