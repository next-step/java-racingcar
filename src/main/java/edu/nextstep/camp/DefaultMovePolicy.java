package edu.nextstep.camp;

import java.util.Random;

public class DefaultMovePolicy implements MovePolicy {
    private final Random random = new Random();
    private static final int MAXIMUM = 10;

    @Override
    public boolean needToMove() {
        return random.nextInt(MAXIMUM) > 4;
    }
}
