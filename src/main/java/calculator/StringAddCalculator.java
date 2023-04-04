package calculator;

import java.util.List;

public class StringAddCalculator {

    private String number;

    public static Integer splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        List<String> numbers = new StringAddSeparator().getSeparatedString(text);
        new StringAddValidator().validateNegativeNumber(numbers);
        return getSumNumber(numbers);
    }

    private static int getSumNumber(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
