package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern splitRegex = Pattern.compile("//(.)\\n(.*)");
    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 입력되었습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "숫자가 아닙니다.";

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
            int parseNumber = 0;

            try {
                parseNumber = Integer.parseInt(number);
            } catch (NumberFormatException exception) {
                throw new RuntimeException(NOT_NUMBER_ERROR_MESSAGE);
            }

            if (parseNumber < 0) {
                throw new RuntimeException(NEGATIVE_ERROR_MESSAGE);
            }

            total += parseNumber;
        }

        return total;
    }

}
