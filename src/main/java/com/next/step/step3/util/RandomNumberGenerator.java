package com.next.step.step3.util;

import java.util.Random;

public class RandomNumberGenerator {

    private static final int BOUND_SET_NUMBER = 10;

    private RandomNumberGenerator() {
    }

    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(BOUND_SET_NUMBER);
    }
}
