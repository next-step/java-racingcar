package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (nullOrEmpty(input)) {
         return 0;
        }

        String[] split = customDelimiter(input);

        return calAllSum(split);
    }

    public static String[] customDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            String customDelimeter = m.group(1);
            String[] tokens = m.group(2).split(customDelimeter);
            return tokens;
        }
        return input.split(",|:");
    }

    public static int stringCastingInt(String input) {
        int i = Integer.parseInt(input);
        return i;
    }

    public static void negative(int number) {
        if(number < 0) {
            throw new RuntimeException();
        }
    }

    public static boolean nullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static int calAllSum(String[] stringArray) {
        int sum = 0;
        for(String s : stringArray) {
            int num = stringCastingInt(s);
            negative(num);
            sum = sum + num;
        }
        return sum;
    }
}
