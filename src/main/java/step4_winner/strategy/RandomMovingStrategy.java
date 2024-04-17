package step4_winner.strategy;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final Random random = new Random();
    private static final int RANDOM_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean isMove() {
        return random.nextInt(RANDOM_RANGE) > MOVE_THRESHOLD;
    }
}
