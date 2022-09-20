package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String delimiter = "[,:]";
        if (m.find()) {
            delimiter = m.group(1);
            text = m.group(2);
        }

        return sumByStringArray(text.split(delimiter));
    }

    private static int sumByStringArray(String[] strs) {
        return Arrays.stream(strs)
            .mapToInt(Integer::parseInt)
            .filter(i -> {
                if (i < 0) {
                    throw new RuntimeException();
                }
                return true;
            })
            .sum();
    }
}
