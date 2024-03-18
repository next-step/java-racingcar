package racing;

import java.util.Random;

public class RandomGenerator {
    private static final int POINT_BOUND = 10;

    public Random random;

    public RandomGenerator() {
        this.random = new Random();
    }

    public int getRandomMovePoint() {
        return this.random.nextInt(POINT_BOUND);
    }
}
