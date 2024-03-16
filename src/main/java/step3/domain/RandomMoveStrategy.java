package step3.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 3;

    @Override
    public boolean move() {
        return getRandomValue() > MOVE_THRESHOLD;
    }

    private int getRandomValue() {
        return random.nextInt(10);
    }
}
