package calculator;

import exception.NegativeNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if(isEmpty(text)) {
            return DEFAULT_VALUE;
        }
        List<PositiveNumber> numbers = toNumbers(split(text));
        return sum(numbers);
    }

    private static String[] split(String text) {
        return StringSplitter.split(text);
    }

    private static List<PositiveNumber> toNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    private static int sum(List<PositiveNumber> numbers) {
        return numbers.stream()
                .reduce(new PositiveNumber("0"), PositiveNumber::add)
                .convertToInt();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
