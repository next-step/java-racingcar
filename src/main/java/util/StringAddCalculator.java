package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (m.find()) {
            return splitAndSum(m.group(2), m.group(1));
        }

        return splitAndSum(input, ",|:");
    }

    private static int splitAndSum(String input, String delimiter) {
        int sum = 0;
        String[] tokens = input.split(delimiter);

        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("Number cannot be negative");
            }
            sum += number;
        }

        return sum;
    }
}
