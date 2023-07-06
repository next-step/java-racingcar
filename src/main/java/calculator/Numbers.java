package calculator;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(String[] values) {
        this.numbers = new ArrayList<>();
        for (String value : values) {
            this.numbers.add(Number.from(value));
        }
    }

    public static Numbers of(String[] numbers) {
        return new Numbers(numbers);
    }

    public int sumAll() {
        Number result = Number.from(0);
        for (Number number : this.numbers) {
            result.plus(number);
        }

        return result.getNumber();
    }
}
