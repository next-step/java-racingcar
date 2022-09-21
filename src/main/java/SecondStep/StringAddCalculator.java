package SecondStep;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final int DEFAULT = 0;
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final Pattern COMMON_SEPARATOR_PATTERN = Pattern.compile("^[0-9,:]*$");
    private static final Pattern ONLY_POSITIVE_NUMBER_PATTERN = Pattern.compile("^\\d*$");

    public static int splitAndSum(String target) {
        if (target == null || target.isEmpty()) {
            return DEFAULT;
        }

        if (ONLY_POSITIVE_NUMBER_PATTERN.matcher(target).matches()) {
            return parseInt(target);
        }

        if (COMMON_SEPARATOR_PATTERN.matcher(target).matches()) {
            String[] tokens = target.split("(,)|(:)");
            List<Integer> numbers = getNumbers(tokens);
            return sum(numbers);
        }

        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(target);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            List<Integer> numbers = getNumbers(tokens);
            return sum(numbers);
        }

        throw new IllegalArgumentException();
    }

    private static int parseInt(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("token [%s] is not a number", token));
        }
    }

    private static List<Integer> getNumbers(String[] tokens) {
        List<Integer> numbers = Arrays.stream(tokens).map(StringAddCalculator::parseInt).collect(Collectors.toList());

        if (hasNegativeNumber(numbers)) {
            throw new IllegalArgumentException(String.format("tokens has a negative number [%s]", Arrays.toString(tokens)));
        }

        return numbers;
    }

    private static boolean hasNegativeNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < 0);
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

}
