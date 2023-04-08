package step3.strategy.move;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private final static Random RANDOM = new Random();
    private final static int RANDOM_BOUND = 10;
    private final static int THRESHOLD = 4;

    @Override
    public boolean isMovable() {

        return generateNumber() >= THRESHOLD;
    }

    private int generateNumber() {

        return RANDOM.nextInt(RANDOM_BOUND);
    }
}
