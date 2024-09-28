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

    private static List<String> split(final String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        String delimiterRegex = getDelimiterRegex(input);
        String target = getTarget(input);
        String[] split = target.split(delimiterRegex);

        return filterEmptyString(split);
    }

    private static String getDelimiterRegex(final String input) {
        final String DEFAULT_DELIMITER_REGEX = ",|:";
        String delimiterRegex = DEFAULT_DELIMITER_REGEX;

        boolean isCustomDelimiter = input.startsWith("//");
        if (!isCustomDelimiter) {
            return DEFAULT_DELIMITER_REGEX;
        }

        final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.matches()) {
            delimiterRegex = matcher.group(1);
            checkValidDelimiter(delimiterRegex);
        }

        return delimiterRegex;
    }

    private static String getTarget(final String input) {
        boolean isCustomDelimiter = input.startsWith("//");
        if (!isCustomDelimiter) {
            return input;
        }

        final String CUSTOM_DELIMITER_REGEX = "//(.*)\n(.*)";
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (matcher.matches()) {
            return matcher.group(2);
        }

        return input;
    }

    private static List<String> filterEmptyString(String[] split) {
        List<String> list = new ArrayList<>();
        for (String number : split) {
            if (!number.isEmpty()) {
                list.add(number);
            }
        }
        return list;
    }

    private static void checkValidDelimiter(String delimiterRegex) {
        List<String> forbiddenCharacters = List.of("$", "^", "*", "(", ")", "{", "}", "[", "]", "+", "?", "|", ".");
        for (String item : forbiddenCharacters) {
            if (delimiterRegex.contains(item)) {
                throw new RuntimeException("사용할 수 없는 구분자입니다.");
            }
        }
    }

    private static List<Integer> convertStringsToIntegers(final List<String> split) {
        List<Integer> result = new ArrayList<>();
        for (String number : split) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private static int sum(final List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            checkNaturalNumber(number);
            sum += number;
        }

        return sum;
    }

    private static void checkNaturalNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수를 계산할 수 없습니다.");
        }
    }
}
