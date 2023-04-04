package calculator;

import java.util.List;

public class StringAddValidator {
    public void validateNegativeNumber(List<String> numbers) {
        long count = numbers.stream()
                .mapToInt(Integer::parseInt)
                .filter(number -> number < 0)
                .count();
        if (count > 0) {
            throw new RuntimeException();
        }
    }
}
