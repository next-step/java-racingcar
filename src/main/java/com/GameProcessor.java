package com;

import java.util.Random;

public class GameProcessor {
    private static final int RANDOM_VALUE_BOUND = 10;
    private static final int MOVE_POSSIBLE_BOUND = 4;

    public int getRandomValue() {
        return new Random().nextInt(RANDOM_VALUE_BOUND);
    }

    public boolean isMovePossible(int i) {
        return i >= MOVE_POSSIBLE_BOUND ? true : false;
    }
}
