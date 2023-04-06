package stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final String NUMBER_REGEX = "^-?\\d+";
    private final List<Integer> numbers;

    public static Numbers of(String text, Delimiters delimiters) {
        return new Numbers(text, delimiters);
    }

    private Numbers(String text, Delimiters delimiters) {
        final List<String> stringNumbers = parseNumbers(text, delimiters);
        this.numbers = stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        validateNumbers();
    }

    private void validateNumbers() {
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
