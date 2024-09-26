package calculator.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.number.Number.ZERO;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(String[] strings) {
        this.numbers = Arrays.stream(strings)
                .map(Number::of)
                .collect(Collectors.toList());
    }

    public int addAll() {
        return this.numbers
                .stream()
                .reduce(ZERO, Number::add)
                .value();
    }

}
