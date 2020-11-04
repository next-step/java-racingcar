package racing.domain;

import java.util.Random;

public class RandomRoulette implements Roulette {

    private final Random random;

    public RandomRoulette() {
        this.random = new Random();
    }

    @Override
    public int spin() {
        return random.nextInt(10);
    }
}
