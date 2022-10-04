package secondStep;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitedString = parseString(input);
        int sum = calculateSum(splitedString);
        return sum;
    }

    public static int calculateSum(String[] strArr) {
        int sum = 0;
        for (String s : strArr) {
            checkMinus(s);
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public static void checkMinus(String element) {
        if (Integer.parseInt(element) < 0) {
            throw new RuntimeException();
        }
    }

    public static String[] parseString(String input) {
        String[] splitedString;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            splitedString = m.group(2).split(customDelimiter);
            return splitedString;
        }
        splitedString = input.split(",|:");
        return splitedString;
    }
}
