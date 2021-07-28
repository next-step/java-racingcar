package racingcar.domain;

import java.util.Random;

public class RandomState implements MoveState {
    private static final int BOUND = 10;
    private static final int GO_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return getRandomInt() >= GO_CONDITION;
    }

    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
