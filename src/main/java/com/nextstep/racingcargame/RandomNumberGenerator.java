package com.nextstep.racingcargame;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int OBJECT_DEFAULT_NUMBER = 10;

    public static int getRandomZeroToNine() {
        return new Random().nextInt(OBJECT_DEFAULT_NUMBER);
    }

}
