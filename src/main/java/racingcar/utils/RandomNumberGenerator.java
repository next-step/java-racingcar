package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int TEN = 10;
    private Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(TEN);
    }
}