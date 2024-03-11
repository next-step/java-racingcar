package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final Random random = new Random();
    private final int MOVE_THRESHOLD = 3;

    @Override
    public boolean move() {
        return getRandomValue() > MOVE_THRESHOLD;
    }

    private int getRandomValue() {
        return random.nextInt(10);
    }
}
