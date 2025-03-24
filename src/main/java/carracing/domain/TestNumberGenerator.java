package carracing.domain;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {
    private final List<Integer> numbers;
    private int index = 0;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int generateNumber() {
        return numbers.get(index++);
    }
}
