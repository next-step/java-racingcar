package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        String[] numbers = separate(input);
        return sum(numbers);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static String[] separate(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(",|:");
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseUnsignedInt(number);
        }
        return result;
    }
}
