package com.nextstep.javaRacing.car;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int MAX_RANDOM = 10;
    private final Random random = new Random();

    @Override
    public int move() {
        int r = random.nextInt(MAX_RANDOM);
        return r >= 4 ? 1 : 0;
    }
}
