package racing.domain;

import java.util.Random;

public class CarMovableStrategy implements MovableStrategy {

    private final static int RANDOM_RANGE = 10;

    @Override
    public int randomMovable() {
        Random random = new Random();
        return random.nextInt(RANDOM_RANGE);
    }
}
