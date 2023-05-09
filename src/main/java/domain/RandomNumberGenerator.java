package domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator{
    private final int totalCount;
    private final Random random;

    public RandomNumberGenerator(int totalCount) {
        this.totalCount = totalCount;
        this.random = new Random();
    }

    @Override
    public int generate() {
        return random.nextInt(totalCount);
    }
}
