package racingcar.service;

import java.util.Random;

public class RandomService {
    private static final int BOUND = 10;

    public int getRandomInt() {
        Random random = new java.util.Random();
        return random.nextInt(BOUND);
    }
}
