package edu.nextstep.camp.racinggame.domain.car.policy;

import java.util.Random;

public class RandomMovePolicy implements MovePolicy {
    private static final int MAXIMUM = 10;
    private static final int MOVE_THRESHOLD = 4;

    private static final RandomMovePolicy instance = new RandomMovePolicy();
    public static RandomMovePolicy getInstance() {
        return instance;
    }

    private final Random random = new Random();

    @Override
    public boolean needToMove() {
        return checkMovable(random.nextInt(MAXIMUM));
    }

    public boolean checkMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
