package calculator;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<String> contents) {
        this.numbers = toInteger(contents);
        validateNonNegative();
    }

    private List<Integer> toInteger(List<String> contents) {
        return contents.stream()
                .map(this::parseToInt)
                .toList();
    }

    private int parseToInt(String content) {
        try {
            return Integer.parseInt(content);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private void validateNonNegative() {
        if (numbers.stream().anyMatch(number -> number < 0)) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
