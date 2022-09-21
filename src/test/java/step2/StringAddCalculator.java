package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        // 요구사항 1
        if (StringUtils.isBlank(text)) {
            return 0;
        }

        // 요구사항 4 & 5
        String[] tokens = splitString(text);

        // 요구사항 6
        List<Integer> numbers = validatePositiveNumbers(convertStringsToNumbers(tokens));

        // 요구사항 2 & 3
        return addNumbers(numbers);
    }

    private static List<Integer> validatePositiveNumbers(List<Integer> numbers) {
        numbers = numbers.stream()
                .peek(number -> {
                    if (number < 0) {
                        throw new NegativeNumberException();
                    }
                })
                .collect(Collectors.toList());
        return numbers;
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

    private static String[] splitString(String text) {
        String[] tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else {
            tokens = text.split(",|:");
        }
        return tokens;
    }

    private static int addNumbers(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            result += number;
        }
        return result;
    }

}
