package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    public static int splitAndSum(final String input) {
        List<String> split = split(input);
        List<Integer> listToSum = convertStringsToIntegers(split);

        return sum(listToSum);
    }

    private static List<Integer> convertStringsToIntegers(final List<String> split) {
        List<Integer> result = new ArrayList<>();
        for (String number : split) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private static List<String> split(final String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        final String DEFAULT_DELIMITER_REGEX = ",|:";
        final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        boolean isCustomDelimiter = matcher.matches();

        String delimiterRegex = isCustomDelimiter ? matcher.group(1) : DEFAULT_DELIMITER_REGEX;
        String target = isCustomDelimiter ? matcher.group(2) : input;

        String[] split = target.split(delimiterRegex);
        for (String number : split) {
            if (!number.isEmpty()) {
                result.add(number);
            }
        }

        return result;
    }

    private static int sum(final List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }

        return sum;
    }
}
