package racing;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_THRESHOLD = 4;

    private final Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(MAX_RANDOM_NUMBER) >= MOVE_THRESHOLD;
    }
}
