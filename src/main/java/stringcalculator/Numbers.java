package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String NUMBER_REGEX = "^-?\\d+";
    private final List<Integer> numbers;

    private Numbers() {
        this.numbers = new ArrayList<>();
    }

    private Numbers(String text, Delimiters delimiters) {
        final List<String> stringNumbers = parseNumbers(text, delimiters);
        this.numbers = stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        validateNegativeNumbers();
        validateNumberSize(delimiters);
    }

    public static Numbers of(String text) {
        if (text == null || text.isBlank()) {
            return new Numbers();
        }
        return new Numbers(text, Delimiters.of(text));
    }

    private void validateNumberSize(Delimiters delimiters) {
        if (delimiters.containsDelimiters()) {
            return;
        }
        if (isNotOnlyOneNumber()) {
            throw new IllegalArgumentException("연산자가 존재하지 않습니다");
        }
    }

    private boolean isNotOnlyOneNumber() {
        return numbers.size() != 1;
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

    private List<String> parseNumbers(String text, Delimiters delimiters) {
        final List<String> numbers = delimiters.split(text);
        if (notParsable(numbers)) {
            throw new IllegalArgumentException("구분자를 제외하고 숫자가 아닌 문자는 입력할 수 없습니다.");
        }

        return numbers;
    }

    private boolean parsable(List<String> numbers) {
        return numbers.stream()
                .allMatch(e -> e.matches(NUMBER_REGEX));
    }

    private boolean notParsable(List<String> numbers) {
        return !parsable(numbers);
    }
}
