package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKEN_INDEX = 2;

    public static int splitAndSum(String text) {
        // 요구사항 1
        if (Optional.ofNullable(text)
                .orElse("")
                .isEmpty()) {
            return 0;
        }

        // 요구사항 4 & 5
        String[] tokens = splitString(text);

        // 요구사항 6
        List<Integer> numbers = validatePositiveNumbers(convertStringsToNumbers(tokens));

        // 요구사항 2 & 3
        return addNumbers(numbers);
    }

    private static String[] splitString(String text) {
        String[] tokens;
        Matcher m = PATTERN.matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_INDEX);
            tokens = m.group(TOKEN_INDEX).split(customDelimiter);
        } else {
            tokens = text.split(",|:");
        }
        return tokens;
    }

    private static List<Integer> convertStringsToNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .map(token -> {
                    try {
                        return Integer.parseInt(token);
                    } catch (Exception e) {
                        throw new InvalidStringException();
                    }
                }).collect(Collectors.toList());
    }

    private static List<Integer> validatePositiveNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new NegativeNumberException();
            }
        }
        return numbers;
    }

    private static int addNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
