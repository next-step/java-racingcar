package stringcalculator;

import java.util.List;

public class Numbers {
    private static final String NUMBER_REGEX = "\\d";
    private final List<String> numbers;

    public static Numbers of(String text, Delimiters delimiters) {
        return new Numbers(text, delimiters);
    }

    private Numbers(String text, Delimiters delimiters) {
        this.numbers = parseNumbers(text, delimiters);
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
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
