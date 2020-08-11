package racing.car;

import java.util.Random;

public class RandomMovableRule implements MovableRule{

    public static final int RANDOM_BOUND = 10;
    public static final int RANDOM_STANDARD = 4;
    private static Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(RANDOM_BOUND) >= RANDOM_STANDARD;
    }

}
