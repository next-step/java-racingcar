package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void add(Number element) {
        numbers.add(element);
    }

    public Number get(int index) {
        return numbers.get(index);
    }
}
