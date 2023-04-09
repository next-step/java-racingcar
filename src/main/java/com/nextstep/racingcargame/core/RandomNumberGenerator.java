package com.nextstep.racingcargame.core;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int RANDOM_BOUND = 10;
    private static final Random RANDOM = new Random();

    public static int getRandomZeroToNine() {
        return RANDOM.nextInt(RANDOM_BOUND);
    }

}
