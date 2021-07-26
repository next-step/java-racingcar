package racingcar.utils;

import java.util.Random;

public class RandomNumber {
    private static final int MAX_VALUE = 10;

    private final Random random = new Random();

    private int randomNumber;

    public int producedRandomNumber() {
        randomNumber = createRandomNum();
        return randomNumber;
    }

    private int createRandomNum() {
        return random.nextInt(MAX_VALUE);
    }
}
