package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] splitedByDelimiter = matcher.group(2).split(customDelimiter);
            return sum(toInts(splitedByDelimiter));
        }

        String[] splitedString = text.split(",|:");
        return sum(toInts(splitedString));
    }

    private static int sum(int[] ints) {
        int result = 0;
        for (int each : ints) {
            result += each;
        }
        return result;
    }

    private static int[] toInts(String[] strings) {
        int[] ints = new int[strings.length];
        for (int index = 0; index < strings.length; index++) {
            ints[index] = toInt(strings[index]);
        }
        return ints;
    }

    private static int toInt(String each) {
        return Integer.parseInt(each);
    }
}
