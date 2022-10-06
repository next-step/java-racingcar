package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static final Number zero = new Number(0);
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(String[] tokens) {
        return new Numbers(Arrays.stream(tokens)
                .map(Number::parse)
                .collect(Collectors.toList()));
    }

    public Number sum() {
        Number sum = zero;
        for (Number number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
