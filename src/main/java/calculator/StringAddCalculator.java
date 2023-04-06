package calculator;

import java.util.List;

public class StringAddCalculator {

    public static Integer sumNumbers(Number number) {
        StringSeparator separator = new StringSeparator();
        List<String> numbers = separator.separateStringByDelimiter(number);
        isContainsNegativeNumber(numbers);
        return sumNumber(numbers);
    }

    private static void isContainsNegativeNumber(List<String> numbers) {
        boolean isContainsNegativeNumber = numbers.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 0);
        if (isContainsNegativeNumber) {
            throw new RuntimeException();
        }
    }

    private static int sumNumber(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}