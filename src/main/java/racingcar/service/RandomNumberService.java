package racingcar.service;

import java.util.Random;

public class RandomNumberService {
    private static final int RANDOM_MAX = 9;
    private static Random random = new Random();

    private RandomNumberService() {}

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_MAX);
    }
}
