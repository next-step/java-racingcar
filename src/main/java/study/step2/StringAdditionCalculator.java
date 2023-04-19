package study.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {
    public static int splitAndSum(String input) {
        if (IsNullOrEmpty(input)) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            final String[] numbers = matcher.group(2).split(delimiter);
            return sum(numbers);
        }

        String[] numbers = input.split("[,:]");

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            checkNegativeNumber(number);
            result += Integer.parseInt(number);
        }

        return result;
    }

    private static void checkNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }

    private static boolean IsNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
