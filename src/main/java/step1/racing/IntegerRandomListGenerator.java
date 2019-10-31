package step1.racing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;

public class IntegerRandomListGenerator implements RandomListGenerator<Integer> {
    private final Random random;

    private IntegerRandomListGenerator() {
        this.random = new Random();
    }

    public static RandomListGenerator<Integer> getInstance() {
        return InstanceHolder.instance;
    }

    @Override
    public List<Integer> gacha(Integer size, Integer bound) {
        return IntStream.range(0, size)
                 .map(num -> random.nextInt(bound))
                 .boxed()
                 .collect(Collectors.toList());
    }

    private static class InstanceHolder {
        private static final IntegerRandomListGenerator instance = new IntegerRandomListGenerator();
    }
}
