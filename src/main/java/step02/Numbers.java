package step02;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        int sum = numbers.stream().mapToInt(Number::getNumber).sum();
        return new Number(sum);
    }

}
