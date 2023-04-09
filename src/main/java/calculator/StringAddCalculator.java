package calculator;

import exception.NegativeNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if(isEmpty(text)) {
            return ZERO;
        }
        return sum(toNumber(split(text)));
    }

    private static String[] split(String text) {
        StringSplitter splitter = new StringSplitter(text);
        return splitter.split();
    }

    private static List<PositiveNumber> toNumber(String[] numbers) throws NegativeNumberException {
        return Arrays.stream(numbers)
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    private static int sum(List<PositiveNumber> numbers) {
        return numbers.stream()
                .mapToInt(PositiveNumber::number)
                .sum();
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
