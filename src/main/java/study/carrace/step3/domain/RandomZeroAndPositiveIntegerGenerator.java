package study.carrace.step3.domain;

import java.util.Random;

public class RandomZeroAndPositiveIntegerGenerator implements RandomIntegerGenerator {
    private static final Random RANDOM = new Random();
    private final int maxNumber;

    public RandomZeroAndPositiveIntegerGenerator(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int generate() {
        return RANDOM.nextInt(maxNumber + 1);
    }
}
