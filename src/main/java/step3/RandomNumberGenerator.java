package step3;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX = 10;

    private final Random random;
    private final int maxNumber;

    private RandomNumberGenerator(Random random, int maxNumber) {
        this.random = new Random();
        this.maxNumber = maxNumber;
    }

    public static RandomNumberGenerator of(int maxNumber) {
        return new RandomNumberGenerator(new Random(), maxNumber);
    }

    @Override
    public int generateNumber() {
        return random.nextInt(MAX);
    }
}
