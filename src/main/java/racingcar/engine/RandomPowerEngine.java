package racingcar.engine;

import java.util.Random;

public class RandomPowerEngine implements PowerEngine {

    private Random random;
    private int bound;

    public RandomPowerEngine() {
        this.random = new Random();
        this.bound = 10;
    }

    @Override
    public int gain() {
        return random.nextInt(this.bound);
    }
}
