package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Integer> numbers;

    private Numbers() {
        this.numbers = new ArrayList<>();
    }

    private Numbers(List<String> stringNumbers) {
        this.numbers = stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        validateNegativeNumbers();
    }

    public static Numbers of(List<String> stringNumbers) {
        if (stringNumbers == null || stringNumbers.isEmpty()) {
            return new Numbers();
        }
        return new Numbers(stringNumbers);
    }

    private void validateNegativeNumbers() {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean isEmpty() {
        return numbers.isEmpty();
    }
}
