package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    Numbers(final String[] strings) {
        this.numbers = Arrays.stream(strings)
            .map(Number::new)
            .collect(Collectors.toList());
    }

    public int sum() {
        return numbers.stream()
            .mapToInt(Number::getNum)
            .sum();
    }
}
