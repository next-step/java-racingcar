package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    public PositiveNumbers(Expression expression) {
        numbers = Arrays.stream(expression.split())
                .map(PositiveNumber::valueOf)
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .reduce(PositiveNumber.valueOf("0"), PositiveNumber::plus)
                .getValue();
    }
}
