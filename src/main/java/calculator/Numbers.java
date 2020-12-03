package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = new ArrayList<>(Collections.unmodifiableList(numbers));
    }

    public Number get(final int index) {
        return numbers.get(index);
    }
}
