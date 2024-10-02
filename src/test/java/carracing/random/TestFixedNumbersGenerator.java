package carracing.random;

import carracing.domain.random.RandomNumberGenerator;

import java.util.Iterator;
import java.util.List;

public class TestFixedNumbersGenerator implements RandomNumberGenerator {
    private final Iterator<Integer> numbers;

    public TestFixedNumbersGenerator(List<Integer> numbers) {
        this.numbers = numbers.iterator();
    }

    @Override
    public int generate() {
        return numbers.hasNext() ? numbers.next() : 0;
    }

}
