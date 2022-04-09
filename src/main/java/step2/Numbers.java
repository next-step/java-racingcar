package step2;

import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sum() {
        int sum = numbers.stream().mapToInt(Number::getNumber).sum();
        return new Number(sum);
    }

}