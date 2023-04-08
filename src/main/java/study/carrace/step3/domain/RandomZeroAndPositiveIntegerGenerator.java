package study.carrace.step3.domain;

import java.util.Random;

public class RandomZeroAndPositiveIntegerGenerator implements RandomIntegerGenerator {
    private final Random random;
    private final int maxNumber;

    public RandomZeroAndPositiveIntegerGenerator(int maxNumber) {
        this.random = new Random();
        this.maxNumber = maxNumber;
    }

    public int generate() {
        return random.nextInt(maxNumber + 1);
    }
}
