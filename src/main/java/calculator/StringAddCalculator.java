package calculator;

import java.util.ArrayList;
import java.util.Collections;
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

        String delimiterRegex;
        if (isCustomDelimiter) {
            delimiterRegex = matcher.group(1);

            String[] list = {"$", "^", "*", "(", ")", "{", "}", "[", "]", "+", "?", "|", "."};
            final List<String> FORBIDDEN_DELIMITERS = List.of(list);

            for (String item : FORBIDDEN_DELIMITERS) {
                if (delimiterRegex.contains(item)) {
                    throw new RuntimeException("사용할 수 없는 구분자입니다.");
                }
            }

        } else {
            delimiterRegex = DEFAULT_DELIMITER_REGEX;
        }

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
            if (number < 0) {
                throw new RuntimeException("음수를 계산할 수 없습니다.");
            }

            sum += number;
        }

        return sum;
    }
}
