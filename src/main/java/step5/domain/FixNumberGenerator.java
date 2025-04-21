package step5.domain;

import java.util.List;

public class FixNumberGenerator implements NumberGenerator{
    private final List<Integer> numbers;
    private int index = 0;

    public FixNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }
    @Override
    public int generate() {
        return numbers.get(index++);
    }
}
