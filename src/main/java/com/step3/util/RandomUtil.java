package com.step3.util;

import java.util.Random;

public class RandomUtil {
    private static final int RANDOM_VALUE_BOUND = 10;

    public static int getRandomValue() {
        return new Random().nextInt(RANDOM_VALUE_BOUND);
    }
}
