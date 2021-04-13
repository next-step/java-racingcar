package carracing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_BOUND = 10;
    private static final int CRITERIA_FOR_WIN = 4;

    @Override
    public boolean isMove() {
        return getRandomNumber() >= CRITERIA_FOR_WIN;
    }

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND);
    }
}
