package caculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.isNull;

public class StringAddCalculator {
    private static final String REGEX_FOR_DEFAULT_DELIMITER = ",|:";
    private static final String REGEX_FOR_CUSTOM_DELIMITER = "//(.)\n(.*)";

    public static int splitAndSum(String input) {
        if(isNullOrEmpty(input)) {
           return 0;
        }

        int[] numbers = getNumbersFromInput(input);

        return getSumOfNumbers(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return isNull(input) || input.isEmpty();
    }

    private static int[] getNumbersFromInput(String input) {
        Matcher customDelimiterMatcher = Pattern.compile(REGEX_FOR_CUSTOM_DELIMITER).matcher(input);

        String[] numbers = customDelimiterMatcher.find() ?
                customDelimiterMatcher.group(2).split(customDelimiterMatcher.group(1)) :
                input.split(REGEX_FOR_DEFAULT_DELIMITER);

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int getSumOfNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce(0, (sum, number) -> {
                    if(number < 0) {
                        throw new RuntimeException();
                    }

                    return sum + number;
                });
    }
}
