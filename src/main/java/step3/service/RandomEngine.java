package step3.service;

import step3.service.CarEngine;

import java.util.Random;

public class RandomEngine implements CarEngine {
    private static final Random random = new Random();
    private static final int RANDOM_BOUND = 10;
    private static final int FORWARD = 4;

    public boolean canGetPower() {
        return random.nextInt(RANDOM_BOUND) >= FORWARD;
    }
}
