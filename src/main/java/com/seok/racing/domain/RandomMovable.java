package com.seok.racing.domain;

import java.util.Random;

public class RandomMovable implements Movable {

    private final static int BOUND = 10;
    private final static int THRESHOLD = 4;

    private Random random = new Random();

    @Override
    public boolean isMovable() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
