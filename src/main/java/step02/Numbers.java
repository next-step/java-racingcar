package step02;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        if (numbers.size() == 0) {
            return new Zero();
        }

        int sum = numbers.stream().mapToInt(Number::getValue).sum();
        return NumberFactory.from(sum);
    }

}
