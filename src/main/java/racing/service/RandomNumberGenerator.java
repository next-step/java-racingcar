package racing.service;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private final int rand;

    public RandomNumberGenerator(int rand) {
        this.rand = rand;
    }

    @Override
    public int generateNumber() {
        return new Random().nextInt(rand);
    }
}
