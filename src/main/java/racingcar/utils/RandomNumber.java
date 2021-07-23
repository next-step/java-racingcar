package racingcar.utils;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_VALUE = 10;

    private Random random;

    public int producedRandomNumber() {
        return createRandomNum();
    }

    private int createRandomNum() {
        random = new Random();
        return random.nextInt(MAX_VALUE);
    }
}
