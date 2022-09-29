package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers create(String[] tokens) {
        List<Number> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(new Number(token));
        }
        return new Numbers(numbers);
    }

    public Number sum() {
        Number sum = new Number(0);
        for (Number number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
