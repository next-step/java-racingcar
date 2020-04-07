package racingcar.domain;

import java.util.Random;

public class RacingCarMovableStrategy implements MovableStrategy {

    private static final int MOVE_CONDITION = 4;

    private static final int MAX_RANDOM_BOUND = 10;

    public boolean isMovable() {
        return getRandom() >= MOVE_CONDITION;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_BOUND);
    }

}
