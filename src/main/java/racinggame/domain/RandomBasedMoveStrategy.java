package racinggame.domain;

import java.util.Random;

public class RandomBasedMoveStrategy implements MoveStrategy {
    private static final int BOUND = 10;
    private static final int MOVE_CONDITION = 4;
    private static final Random random = new Random();

    @Override
    public boolean moveOrNot() {
        return this.getRandomNum() >= MOVE_CONDITION;
    }

    private int getRandomNum() {
        return random.nextInt(BOUND);
    }
}
