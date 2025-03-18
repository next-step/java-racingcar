package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_SEPERATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPERATOR_PATTERN = ",|:";
    private static final int CUSTOM_SEPARATOR_GROUP_INDEX = 1;
    private static final int CUSTOM_NUMBERS_GROUP_INDEX = 2;

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        String[] numbers = splitByCustomOrDefault(input);
        numbers = trimNumbers(numbers);
        validateNonNegative(numbers);

        return sumNumbers(numbers);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isBlank();
    }

    private static void validateNonNegative(String[] numbers) {
        String negative = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(n -> n < 0)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + b)
                .orElse("");

        if (!negative.isEmpty()) {
            throw new RuntimeException("음수는 허용되지 않습니다: " + negative);
        }
    }

    private static String[] splitByCustomOrDefault(String input) {
        Matcher m = matchCustomSeperator(input);
        return m.find()
                ? splitByCustomSeperator(m) :
                splitByDefaultSeperator(input);
    }

    private static String[] trimNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(String::trim)
                .toArray(String[]::new);
    }

    private static Matcher matchCustomSeperator(String input) {
        return CUSTOM_SEPERATOR_PATTERN.matcher(input);
    }

    private static String[] splitByCustomSeperator(Matcher m) {
        return m.group(CUSTOM_NUMBERS_GROUP_INDEX).split(Pattern.quote(m.group(CUSTOM_SEPARATOR_GROUP_INDEX)));
    }

    private static String[] splitByDefaultSeperator(String input) {
        return input.split(DEFAULT_SEPERATOR_PATTERN);
    }

    private static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
