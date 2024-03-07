package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern splitRegex = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Matcher matcher = splitRegex.matcher(input);
        if (matcher.find()) {
            return sumUsingCustomDelimiter(input, matcher);
        }

        String[] numbers = input.split(",|:");

        return sum(numbers);
    }


    private static int sumUsingCustomDelimiter(String input, Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] numbers = matcher.group(2).split(customDelimiter);

        return sum(numbers);
    }

    private static int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            int parseNumber = Integer.parseInt(number);

            assertPositiveNumber(parseNumber);

            total += parseNumber;
        }

        return total;
    }

    private static void assertPositiveNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

}
