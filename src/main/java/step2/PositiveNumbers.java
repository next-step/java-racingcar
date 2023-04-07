package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    public PositiveNumbers(Expression expression) {
        numbers = Arrays.stream(expression.split())
                .map(PositiveNumber::new)
                .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
                .map(PositiveNumber::getValue)
                .reduce(0, Integer::sum);
    }
}
