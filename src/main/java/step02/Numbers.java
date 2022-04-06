package step02;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public Number sum() {
        int sum = numbers.stream().mapToInt(Number::getValue).sum();

        if (sum == 0 || numbers.size() == 0) {
            return new Zero(sum);
        }

        if (sum > 0) {
            return new PositiveNumber(sum);
        }

        throw new IllegalArgumentException("음수값 입니다.");
    }

}
