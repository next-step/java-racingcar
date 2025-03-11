package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String delimiter = ",|:";

    public static int splitAndSum(final String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        int total = 0;

        Pattern pattern = Pattern.compile("(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            delimiter = matcher.group(1);
            String[] numbers = matcher.group(2).split(delimiter);
            total = sumParsedNumbers(numbers);
        } else {
            String[] numbers = input.split(delimiter);
            total = sumParsedNumbers(numbers);
        }

        return total;
    }

    private static int sumParsedNumbers(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            int parsed = Integer.parseInt(number);
            if (parsed < 0) {
                throw new RuntimeException();
            }

            total += parsed;
        }

        return total;
    }

}
