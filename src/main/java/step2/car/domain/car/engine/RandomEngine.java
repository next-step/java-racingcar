package step2.car.domain.car.engine;

import java.util.Random;

public class RandomEngine implements Engine {

    private static final int RANDOM_BOUND = 10;

    @Override
    public int getPower() {
        return new Random().nextInt(RANDOM_BOUND);
    }
}
