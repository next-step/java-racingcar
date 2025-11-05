package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 힌트 활용
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }

        String[] strArray = input.split(",|:");
        return sum(strArray);
    }

    private static int sum(String[] strArray) {
        int total = 0;
        for (String str : strArray) {
            total += StringToPositiveInt(str);
        }
        return total;
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static int StringToPositiveInt(String str) {
        int number = parseInt(str);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

}
